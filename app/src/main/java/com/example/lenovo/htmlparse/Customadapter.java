package com.example.lenovo.htmlparse;


        import android.app.Activity;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

        import java.util.ArrayList;

/**
 * Created by user on 1/9/2018.
 */


public class Customadapter extends ArrayAdapter<ListItem> {
    private static final String LOG_TAG = Customadapter.class.getSimpleName();


    public Customadapter (Activity Context, ArrayList<ListItem> words){
        super(Context,0,words);

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView=convertView;
        if(listItemView==null)
        {
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_view,parent,false);

        }
        ListItem currentWord=getItem(position);



        TextView defaultTextView=(TextView) listItemView.findViewById(R.id.nameTextViewID);
        defaultTextView.setText(currentWord.getdefaultTranslation());
        TextView miwokTextView=(TextView) listItemView.findViewById(R.id.infoTextViewID);
        miwokTextView.setText(currentWord.getMiwok());
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.imageView1ID);
        imageView.setImageResource(currentWord.getImageResourceId());

        return listItemView;
    }
}