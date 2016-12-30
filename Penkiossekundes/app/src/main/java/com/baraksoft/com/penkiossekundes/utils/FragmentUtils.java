package com.baraksoft.com.penkiossekundes.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * @author Laurynas
 * @since 2016-12-21
 */
public class FragmentUtils {
    private FragmentUtils(){}

    public static void change(Fragment finalFragment, FragmentManager manager, int componentId){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(componentId, finalFragment);
        transaction.addToBackStack(null);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.commit();
    }

    public static void changeWithBack(Fragment finalFragment, FragmentManager manager, int componentId){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(componentId, finalFragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.commit();
    }

    public static void change(Fragment finalFragment, FragmentManager manager, int componentId, String tag){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(componentId, finalFragment, tag);
        transaction.addToBackStack(null);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.commit();
    }
}
