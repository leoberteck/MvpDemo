package com.example.leo.mvpdemo.utils;


import com.example.leo.mvpdemo.mvp.MainPresenter;
import com.example.leo.mvpdemo.mvp.MainActivityMVP;

import static com.example.leo.mvpdemo.mvp.MainActivityMVP.*;

public final class PresenterFactory {

    private static IMainPresenter mainPresenter;

    public static IMainPresenter getMainPresenter(){
        if(mainPresenter == null){
            mainPresenter = new MainPresenter();
        }
        return mainPresenter;
    }
}
