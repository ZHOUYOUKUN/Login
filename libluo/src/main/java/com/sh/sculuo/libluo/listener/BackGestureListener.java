package com.sh.sculuo.libluo.listener;

import android.app.Activity;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

import com.sh.sculuo.libluo.util.DisplayUtil;


/**
 * * 配合BasicActivity中的返回手势监听接口
 */
public class BackGestureListener implements OnGestureListener {

	private Activity activity;

	private int screenWidth;

	public BackGestureListener ( Activity activity ) {

		this.activity = activity;
		screenWidth = DisplayUtil.getScreenWidth ( activity );
	}

	@Override
	public boolean onDown ( MotionEvent e ) {

		return false;
	}

	@Override
	public boolean onFling ( MotionEvent e1, MotionEvent e2, float velocityX,
	                         float velocityY ) {

		return false;
	}

	@Override
	public void onLongPress ( MotionEvent e ) {

	}

	@Override
	public boolean onScroll ( MotionEvent e1, MotionEvent e2, float distanceX,
	                          float distanceY ) {

		if ( e1.getX () < screenWidth / 4 && ( e2.getX () - e1.getX () ) > 100 && Math.abs ( e1.getY () - e2.getY () ) < 60 ) {
			activity.finish ();
			return true;
		}
		return false;
	}

	@Override
	public void onShowPress ( MotionEvent e ) {

	}

	@Override
	public boolean onSingleTapUp ( MotionEvent e ) {

		return false;
	}

}
