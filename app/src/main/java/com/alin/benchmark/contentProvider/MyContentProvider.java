package com.alin.benchmark.contentProvider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {
    protected UriMatcher uriMatcher;
    protected SQLiteDatabase db;
    public final static Uri CONTENT_URI = Uri.parse("content://com.alin.benchmark.provider/users");
    public final static String AUTHORITY = "com.alin.benchmark.provider";

    @Override
    public boolean onCreate() {
        SqliteHelper helper = new SqliteHelper(getContext());
        db = helper.getWritableDatabase();
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, "users", 1);
        return db != null;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        int code = uriMatcher.match(uri);
        return db.query("users", projection, selection, selectionArgs, null, null, sortOrder);
    }

    @Override
    public String getType(Uri uri) {
        return "vnd.android.cursor.dir/vnd.alin.users";
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long id = db.insert("users", "id", values);
        if (id >= 0) {
            Uri result = ContentUris.appendId(
                    uri.buildUpon(), id).build();
            getContext().getContentResolver().notifyChange(uri, null, true);
            return result;
        } else {
            throw new SQLException("Fail to insert to row :" + uri);
        }
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int count = db.delete("users", selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null, true);
        return count;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        int count = db.update("users", values, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null, true);
        return count;
    }

}
