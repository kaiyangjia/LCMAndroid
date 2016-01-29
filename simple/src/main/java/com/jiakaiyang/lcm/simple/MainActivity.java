package com.jiakaiyang.lcm.simple;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.jiakaiyang.lcm.library.manager.RelationManager;
import com.jiakaiyang.lcm.library.utils.TypeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        test();
    }


    private void test(){
        RelationManager relationManager = new RelationManager();
        ListView listView = (ListView) findViewById(R.id.list_test);

        List data = new ArrayList<>();
        for(int i=0;i<10;i++){
            TestBean bean = new TestBean(78, "http://content.12530.com/web/p/new/artist/20130703/31687/l_9zLQOlNiflx5liaL.jpg" ,"Plant");
            data.add(bean);
        }
        int id = relationManager.bind(listView, data.get(0), R.layout.item_list);
        Map<Integer, String> bulidMap = new HashMap<>();
        bulidMap.put(R.id.item_age, "age");
        bulidMap.put(R.id.item_name, "name");
        bulidMap.put(R.id.item_avatar, "avatar");
        relationManager.buildMapping(bulidMap, id);
        relationManager.show(this, id, data);
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
}
