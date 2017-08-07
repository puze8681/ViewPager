package hoosasack.viewpager.FragmentAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import hoosasack.viewpager.Fragment.BlueFragment;
import hoosasack.viewpager.Fragment.GreenFragment;
import hoosasack.viewpager.Fragment.RedFragment;

/**
 * Created by parktaejun on 2017. 8. 7..
 */

public class TabLayoutAdapter extends FragmentStatePagerAdapter {
    private int tabCount;

    public TabLayoutAdapter(FragmentManager fm, int tabCount){
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                RedFragment redFragment = new RedFragment();
                return redFragment;
            case 1:
                GreenFragment greenFragment = new GreenFragment();
                return greenFragment;
            case 2:
                BlueFragment blueFragment = new BlueFragment();
                return blueFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 0;
    }
}
