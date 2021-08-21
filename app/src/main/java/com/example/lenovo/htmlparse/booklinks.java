package com.example.lenovo.htmlparse;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class booklinks extends AppCompatActivity {

    TextView tv;
    String sc="";

    public String amazon(String book){
        //String amazon1[]=new String[3];
        String sn[] = book.split(" ");
        String add="";
        for(int i = 0; i < sn.length-1; i++)
            add=add + sn[i]+"+";
        add=add+sn[sn.length-1];
        String link = "https://www.amazon.in/s/ref=nb_sb_noss_2?url=search-alias%3Dstripbooks&field-keywords="+add;
        String pat = "<span class="+"\"a-size-base a-color-price s-price a-text-bold\""+"><span class="+"\"currencyINR\""+">&nbsp;&nbsp;</span>";
        String source = getwebsite(link);
        int index = KMPSearch(pat, source);
        String cut = source.substring(index+105, index+115);
        String price[] = cut.split("<");
        String s1=" title=";
        String s2="src=";
        String s3="";
        String s4="";
        String image= img(source,index);
        String title=book_title(source,index,s1);
        /*while(true){

            s4=source.substring(index-4, index);
            if(s4.equals(s2))
            {
                index++;
                while(true)
                {
                    if(source.charAt(index)!='"')
                    {
                        image=image+source.charAt(index);
                        index++;
                    }
                    else
                        break;
                }
                break;
            }
            index--;
        }
        while(true){

            s3=source.substring(index-7, index);
            if(s3.equals(s1))
            {
                index++;
                while(true)
                {
                    if(source.charAt(index)!='"')
                    {
                        title=title+source.charAt(index);
                        index++;
                    }
                    else
                        break;
                }
                break;
            }
            index--;
        }
        amazon1[0]= price[0];
        amazon1[1]= image;
        amazon1[2]= title;*/
    return(title+"^"+price[0]+"^"+image+"^");
    }
    public String google_play(String book){
        String gp[] = book.split(" ");
        String add = "";
        for(int i=0; i<gp.length-1;i++){
            add = add + gp[i]+"%20";
        }
        add += gp[gp.length - 1];
        String link = "https://play.google.com/store/search?q="+add+"&c=books&hl=en";
        String pat = "<span class="+"\""+"display-price"+"\""+">";
        String source = getwebsite(link);
        int index = KMPSearch(pat,source);
        String cut = source.substring(index+29,index+38);
        String s1 = " aria-label=";
        String price[] = cut.split("<");
        String title = book_title(source,index,s1);
        String image = img(source,index);
        return(title+"^"+price[0]+"^"+image+"^");
    }
    public String img(String source, int index){
        String s4="";
        String s2="src=";
        String image="";
        while(true){

            s4=source.substring(index-4, index);
            if(s4.equals(s2))
            {
                index++;
                while(true)
                {
                    if(source.charAt(index)!='"')
                    {
                        image=image+source.charAt(index);
                        index++;
                    }
                    else
                        break;
                }
                break;
            }
            index--;
        }
        return image;
    }
    public String book_title(String source, int index, String pat){
        String s1=pat;
        String s3="";
        String title="";
        while(true){

            s3=source.substring(index-7, index);
            if(s3.equals(s1))
            {
                index++;
                while(true)
                {
                    if(source.charAt(index)!='"')
                    {
                        title=title+source.charAt(index);
                        index++;
                    }
                    else
                        break;
                }
                break;
            }
            index--;
        }
        return title;
    }
    public String getwebsite(String website){
        String resString ="";
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(website);
        try{
            HttpResponse response;
            response = httpClient.execute(httpget);
            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "windows-1251"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while((line=reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            resString = sb.toString();
            is.close();
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(booklinks.this, "Error!", Toast.LENGTH_SHORT).show();

        }
        return resString;
    }
    int KMPSearch(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();
        int lps[] = new int[M];
        int j = 0;
        computeLPSArray(pat,M,lps);

        int i = 0;
        while (i < N)
        {
            if (pat.charAt(j) == txt.charAt(i))
            {
                j++;
                i++;
            }
            if (j == M)
            {
                return i-j;
            }
            else if (i < N && pat.charAt(j) != txt.charAt(i))
            {
                if (j != 0)
                    j = lps[j-1];
                else
                    i = i+1;
            }
        }
        return -1;
    }

    void computeLPSArray(String pat, int M, int lps[])
    {
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while (i < M)
        {
            if (pat.charAt(i) == pat.charAt(len))
            {
                len++;
                lps[i] = len;
                i++;
            }
            else
            {
                if (len != 0)
                {
                    len = lps[len-1];
                }
                else
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}

