package example.poccontrolinho;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Controle_Conta implements IControle{

    private RelativeLayout content;
    private LinearLayout background;
    private ImageView arrow;
    private TextView txt;
    private ListView list;

    private String _selected;
    private SelectedItemEvent _selectedItemEvent;

    @Override
    public int LayoutID() {
        return R.layout.control_conta;
    }

    @Override
    public void Populate(View view) {

        background = (LinearLayout) view.findViewById(R.id.background);
        content = (RelativeLayout) view.findViewById(R.id.content);
        arrow = (ImageView) view.findViewById(R.id.arrow);
        txt = (TextView) view.findViewById(R.id.txt);
        list = (ListView) view.findViewById(R.id.list);

        txt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (_selectedItemEvent != null)
                    _selectedItemEvent.onSelectItem(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        final ArrayList<String> dogsList = new ArrayList<>();
        dogsList.add("Akita Inu::1");
        dogsList.add("Alaskan Klee Kai::2");

        background.animate().setDuration(1).translationY(-9999).start();
        list.animate().setDuration(1).translationY(-1000).start();

        content.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                arrow.setImageDrawable(view.getResources().getDrawable(android.R.drawable.arrow_up_float));

                background.setVisibility(View.VISIBLE);
                background.animate().setDuration(1).translationY(0);

                list.setVisibility(View.VISIBLE);
                list.animate().setDuration(900).translationY(0);
                list.setAdapter(PopulateAdapter(view, dogsList));
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        arrow.setImageDrawable(view.getResources().getDrawable(android.R.drawable.arrow_down_float));

                        background.setVisibility(View.GONE);

                        list.animate().setDuration(1).translationY(-1000).start();
                        list.setVisibility(View.GONE);

                        String item = (String) adapterView.getItemAtPosition(i);
                        String[] itemArr = item.split("::");
                        String text = itemArr[0];

                        txt.setText(text);
                    }
                });
            }
        });
    }

    @Override
    public ArrayAdapter<?> PopulateAdapter(View view, ArrayList<?> lista) {
        ArrayAdapter<?> adapter = new ArrayAdapter(view.getContext(), R.layout.rows_listview, lista) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                Context context = (getContext());

                View rowView;
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                rowView = inflater.inflate(R.layout.rows_listview, null);

                String item = getItem(position).toString();
                String[] itemArr = item.split("::");
                String text = itemArr[0];
                String id = itemArr[1];
                setSelectedItem(item);

                TextView textView =(TextView) rowView.findViewById(R.id.txt);
                textView.setText(text);

                return rowView;
            }
        };

        return adapter;
    }

    @Override
    public <T> void setSelectedItem(T value) {
        _selected = (String) value;
    }

    @Override
    public <T> T getSelectedItem() {
        return (T) _selected;
    }

    @Override
    public void setSelectedItemEvent(SelectedItemEvent selectedItemEvent){
        _selectedItemEvent = selectedItemEvent;
    }
}
