package course.labs.activitylab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOne extends Activity {

	// Use these as keys when you're saving state between reconfigurations
	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityOne";

    private int mCreate;
    private int mRestart;
    private int mStart;
    private int mResume;

    // You will need to increment these variables' values when their
    // corresponding lifecycle methods get called.

    public static TextView mTvCreate;
    public static TextView mTvRestart;
    public static TextView mTvStart;
    public static TextView mTvResume;

	// for displaying the current count of each counter variable

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);

        mTvCreate = (TextView) findViewById(R.id.xscreate);
        mTvRestart = (TextView) findViewById(R.id.xsrestart);
        mTvStart = (TextView) findViewById(R.id.xsstart);
        mTvResume = (TextView) findViewById(R.id.xsresume);

        setButtons();

		if (savedInstanceState != null) {
            mTvCreate.setText(mCreate);
            mTvRestart.setText(mRestart);
            mTvStart.setText(mStart);
            mTvResume.setText(mResume);
		}

		Log.i(TAG, "Entered the onCreate() method");

        mCreate++;
        displayCounts();
	}

    private void setButtons() {
        setButtonForLaunchActivityTwo();
        setButtonForLaunchActivityThree();
    }

    private void setButtonForLaunchActivityThree() {
        Button launchActivityThreeButton = (Button) findViewById(R.id.buttonLaunchActivityThree);
        launchActivityThreeButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Click button");
                Intent activityThreeIntent = new Intent(view.getContext(), ActivityThree.class);
                startActivity(activityThreeIntent);

            }
        });
    }

    private void setButtonForLaunchActivityTwo() {
        Button launchActivityTwoButton = (Button) findViewById(R.id.bLaunchActivityTwo);
        launchActivityTwoButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent activityTwoIntent = new Intent(v.getContext(), ActivityTwo.class );
                activityTwoIntent.putExtra("mStart",100);
                startActivity(activityTwoIntent);
            }
        });
    }

    @Override
	public void onStart() {
		super.onStart();

		Log.i(TAG, "Entered the onStart() method");
        mStart++;
        displayCounts();
	}

	@Override
	public void onResume() {
		super.onResume();

		Log.i(TAG, "Entered the onResume() method");
        mResume++;
        displayCounts();
	}

	@Override
	public void onPause() {
		super.onPause();

		Log.i(TAG, "Entered the onPause() method");
	}

	@Override
	public void onStop() {
		super.onStop();

		Log.i(TAG, "Entered the onStop() method");
	}

	@Override
	public void onRestart() {
		super.onRestart();

		Log.i(TAG, "Entered the onRestart() method");
        mRestart++;
        displayCounts();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		Log.i(TAG, "Entered the onDestroy() method");
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
       savedInstanceState.putInt("mStart",mStart);
       savedInstanceState.putInt("mResume",mResume);
       savedInstanceState.putInt("mRestart",mRestart);
       savedInstanceState.putInt("mCreate",mCreate);
       Log.i(TAG, "Entered the onSaveInstanceState() method");
	}

	public void displayCounts() {

		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);

	}
}
