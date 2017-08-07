package hoosasack.viewpager;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import hoosasack.viewpager.FragmentAdapter.TabLayoutAdapter;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    Toolbar toolbar;
    TabLayout tabLayout;
    TabLayoutAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        pagerAdapter = new TabLayoutAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        tabLayout.addTab(tabLayout.newTab().setText("레드!").setTag("fragment_red"));
        tabLayout.addTab(tabLayout.newTab().setText("그린!").setTag("fragment_green"));
        tabLayout.addTab(tabLayout.newTab().setText("블루!").setTag("fragment_blue"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("레드!");


        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                switch (tabLayout.getSelectedTabPosition()){
                    case 0:
                        getSupportActionBar().setTitle("레드");
                        setTitleColor(Color.RED);
                        tab.setText("레드!");
                        break;
                    case 1:
                        getSupportActionBar().setTitle("그린");
                        setTitleColor(Color.GREEN);
                        tab.setText("그린!");
                        break;
                    case 2:
                        getSupportActionBar().setTitle("블루");
                        setTitleColor(Color.BLUE);
                        tab.setText("블루!");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                switch (tabLayout.getSelectedTabPosition()){
                    case 0:
                        tab.setText("레드");
                        break;
                    case 1:
                        tab.setText("그린");
                        break;
                    case 2:
                        tab.setText("블루");
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
