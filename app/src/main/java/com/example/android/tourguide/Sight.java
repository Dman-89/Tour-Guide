package com.example.android.tourguide;

import android.os.Parcel;
import android.os.Parcelable;

public class Sight implements Parcelable {

    private String mName;
    private String mAddress;
    private String mDescription;
    private int mImageResourceId;

    public Sight(String name, String description, int resourceId) { //, int soundId
        this.mName = name;
        this.mDescription = description;
        this.mImageResourceId = resourceId;
    }

    public Sight(String name, String address, String description, int resourceId) { //, int soundId
        this.mName = name;
        this.mAddress = address;
        this.mDescription = description;
        this.mImageResourceId = resourceId;
    }

    public String getName () {
        return mName;
    }

    public String getAddress () {
        return mAddress;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getImageResourceId () {
        return mImageResourceId;
    }


    protected Sight(Parcel in) {
        mName = in.readString();
        mAddress = in.readString();
        mDescription = in.readString();
        mImageResourceId = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mAddress);
        dest.writeString(mDescription);
        dest.writeInt(mImageResourceId);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Sight> CREATOR = new Parcelable.Creator<Sight>() {
        @Override
        public Sight createFromParcel(Parcel in) {
            return new Sight(in);
        }

        @Override
        public Sight[] newArray(int size) {
            return new Sight[size];
        }
    };
}
