package com.example.lenovo.htmlparse;

/**
 * Created by Lenovo on 12-01-2018.
 */

public class ListItem {
    /**
     * Created by user on 1/10/2018.
     */
    private String mdefaultTranslation;
        private  String mMiwok;
        private int mImageResourceId;
        public ListItem(String defaultTranslation, String Miwok,int ImageResourceId)
        {mdefaultTranslation=defaultTranslation;
            mMiwok=Miwok;
            mImageResourceId=ImageResourceId;
        }
        public String getdefaultTranslation(){
            return mdefaultTranslation;
        }
        public String getMiwok(){
            return mMiwok;
        }
        public int getImageResourceId() {
            return mImageResourceId;
        }
    }

