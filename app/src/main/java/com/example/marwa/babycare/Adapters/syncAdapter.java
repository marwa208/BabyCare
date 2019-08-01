package com.example.marwa.babycare.Adapters;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;

public class syncAdapter extends AbstractThreadedSyncAdapter {


    ContentResolver contentResolver;

    public syncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize);

        contentResolver = context.getContentResolver();
    }


    public syncAdapter(
            Context context,
            boolean autoInitialize,
            boolean allowParallelSyncs) {
        super(context, autoInitialize, allowParallelSyncs);

        contentResolver = context.getContentResolver();

    }

    @Override
    public void onPerformSync(Account account, Bundle extras, String authority, ContentProviderClient provider, SyncResult syncResult) {

    }
}