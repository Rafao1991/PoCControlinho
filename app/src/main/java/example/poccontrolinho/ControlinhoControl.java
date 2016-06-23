package example.poccontrolinho;

import android.content.Context;
import android.util.AttributeSet;
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
import java.util.List;

public class ControlinhoControl extends RelativeLayout {

    IControle controle;

    public ControlinhoControl(Context context){
        super(context);
    }

    public ControlinhoControl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ControlinhoControl(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void initControl(IControle controle){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(controle.LayoutID(),this);

        this.controle = controle;

        this.controle.Populate(view);
    }

    public <T> T getSelectedItem() {
        return this.controle.getSelectedItem();
    }

    public void setSelectedItemEvent(SelectedItemEvent selectedItemEvent){
        this.controle.setSelectedItemEvent(selectedItemEvent);
    }
}
