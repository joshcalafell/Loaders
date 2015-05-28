package com.rabbitfighter.loaders;

import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Important to implement LoaderManager#LoaderCallbacks<T>
 **/
public class MainActivity extends ActionBarActivity implements LoaderManager.LoaderCallbacks<ArrayList<String>> {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("Should load in 2 seconds...");

        /* Get an instance of the loader manager and initialize it. */
        this.getLoaderManager().initLoader(5, null, this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * When the loader is created.
     * @param id
     * @param args
     * @return
     */
    @Override
    public Loader<ArrayList<String>> onCreateLoader(int id, Bundle args) {
        /* Create a new instance of custom loader */
        RandomStringLoader loader = new RandomStringLoader(this);
        /* Return the loader */
        return loader;
    }

    /**
     * Loader is finished.Serves the text to the text view from the data passed in
     * with the loader.
     * @param loader
     * @param data
     */
    @Override
    public void onLoadFinished(Loader<ArrayList<String>> loader, ArrayList<String> data) {
        textView.setText("Here are 20 random lines of 20 chars (a-zA-Z0-9)\n\n");
        for (String text : data) {
            textView.setText(textView.getText() + text);
        }
    }

    /**
     * Not sure yet...
     * TODO: Research this...
     * @param loader
     */
    @Override
    public void onLoaderReset(Loader<ArrayList<String>> loader) {

    }
}
