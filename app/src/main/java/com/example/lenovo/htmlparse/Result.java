package com.example.lenovo.htmlparse;
import android.content.res.Resources;
import java.util.StringTokenizer;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
        import android.os.Bundle;
        import android.widget.ListView;

        import java.util.ArrayList;
public class Result extends AppCompatActivity {
    String book_user = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        ArrayList<ListItem> words = new ArrayList<ListItem>();
        int id = Resources.getSystem().getIdentifier("church", "drawable", "android");
        /*MainActivity obj2 = new MainActivity();
        obj2.call();*/
        //String xyz= "the alchemist";
        //String book_user = getIntent().getStringExtra("book name");
        booklinks first=new booklinks();
        String Site1=first.amazon(book_user);
        StringTokenizer tokens = new StringTokenizer(Site1, "^");
        String first1 = tokens.nextToken();// this will contain "Fruit"
        String second = tokens.nextToken();// this will contain " they taste good"
        String third = tokens.nextToken();
        words.add(new ListItem(first1,second,id));
        words.add(new ListItem("two","otiiko",id));
        words.add(new ListItem("three","tolookosu",id));
        words.add(new ListItem("four","nassokka",id));
        words.add(new ListItem("five","temmokka",id));
        words.add(new ListItem("six","kenekaku",id));
        words.add(new ListItem("se ven","kawinta",id));
        words.add(new ListItem("eight","wo'e",id));
        words.add(new ListItem("nine","oyyissa",id));
        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        Customadapter  Adapter = new Customadapter(this,words);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(Adapter);
    }/*
    public void assign(String x){
        book_user = x;
    }*/
}