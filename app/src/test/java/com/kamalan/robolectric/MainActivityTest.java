package com.kamalan.robolectric;

import android.view.View;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest
{
    private MainActivity mMainActivity;

    @Before
    public void setup()  {
        this.mMainActivity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void checkActivityNotNull() throws Exception {
        assertNotNull("How come SplashActivity is null???", this.mMainActivity);
    }

    @Test
    public void checkVisibilityOfCardView() throws Exception {
        View ivBranding = this.mMainActivity.findViewById(R.id.ivBranding);
        Assert.assertEquals(ivBranding.getVisibility(), View.VISIBLE);

        View cardView = this.mMainActivity.findViewById(R.id.splash_error_layout);
        int visibility = cardView.getVisibility();
        String txt;
        switch (visibility)
        {
            case 0: txt = "VISIBLE"; break;
            case 4: txt = "INVISIBLE"; break;
            case 8: txt = "INVISIBLE"; break;
            default: txt = "UNKNOWN"; break;
        }
        System.out.println("The visibility of CardView is: " + txt);

        assertEquals("CardView MUST be invisible by default.", 8, visibility);
    }
}