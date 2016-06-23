package example.poccontrolinho;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Santander on 22/06/16.
 */
public interface IControle {

    int LayoutID();

    void Populate(View view);

    ArrayAdapter<?> PopulateAdapter(View view , ArrayList<?> lista);

    <T> T getSelectedItem();

    <T> void setSelectedItem(T value);

    void setSelectedItemEvent(SelectedItemEvent selectedItemEvent);
}

