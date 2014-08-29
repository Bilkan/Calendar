package net.uyghurdev.chisla.re;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.widget.RemoteViews;
public class Hellowidget extends AppWidgetProvider {
	public String hepte;
	public String ay_uy;
	public String ay_eng;
	public  int i;
	private int mDay;
	public Context context;
	private static SimpleDateFormat yil = new SimpleDateFormat("yyyy/MM");
	private static SimpleDateFormat ay = new SimpleDateFormat("MM");
	private static SimpleDateFormat kun = new SimpleDateFormat("d");
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,int[] appWidgetIds){
	     
		 //
		 String yill = yil.format(new Date());
		 String ayy = ay.format(new Date());
		 String kunn = kun.format(new Date());
		 i = Integer.parseInt(ayy);
		 final Calendar c = Calendar.getInstance();
		 mDay = c.get(Calendar.DAY_OF_WEEK);
		
	 switch (mDay)
	        {

	        case 1:
                hepte=" يەكشەنبە";
	  break;
	        case 2: 
	        	 hepte=" دۈشەنبە";
	        	
	  break;
	        case 3:
	        	hepte=" سەيشەنبە ";
	  break;
	        case 4:
	        	 hepte=" چارشەنبە";
	      
	  break;
	        case 5:
	        	 hepte=" پەيشەنبە";
	  break;
	 	        case 6:
	 	        	 hepte="   جۈمە  ";
	  break;
	 	        case 7:
	 	        	 hepte="شەنبە";
	  break;
	        }
        
	 
	 
	 
		 switch (i)
	        {
	        case 1:
	        	ay_uy="  قەھرىتان";
	        	ay_eng="   يانۋار";
	    break;
	        case 2: 
	        	ay_uy="    ھۇد ";
	        	ay_eng="   فېۋرال";
	    break;
	        case 3:
	        	ay_uy="  نەۋرۇز ";
	        	ay_eng="     مارت ";
	    break;
	        case 4:
	        	ay_uy="  ئۇمۇد";
	        	ay_eng="   ئاپرىل";
	      
	    break;
	        case 5:
	        	ay_uy="  باھار";
	        	ay_eng="      ماي";
	 	 break;
	 	        case 6:
	 	        	ay_uy=" سەپەر";
	 	        	ay_eng="   ئىيۇن";
	 	 break;
	 	        case 7:
	 	        	ay_uy=" چىللە";
	 	        	ay_eng="   ئىيۇل";
	 	 break;
	 	       case 8:
	 	    	  ay_uy=" تومۇز";
	 	    	 ay_eng="   ئاۋغۇست";
	 	 break;
	 	      case 9:
	 	    	 ay_uy=" مىزان";
	 	    	ay_eng="   سىنتەبىر";
	 	 break;
		 	       case 10:
		 	    	  ay_uy=" ئوغۇز";
		 	    	 ay_eng="   ئۆكتەبىر";
		 break;
		 	       case 11:
		 	    	  ay_uy=" ئوغلاق";
		 	    	 ay_eng="   نويابىر";
		 break;
		 	      case 12:
		 	    	 ay_uy="كۆنەك";
		 	    	ay_eng="   دېكابىر";
		 break;
	        }
		 
		 
		 
	     RemoteViews updateViews = new RemoteViews(context.getPackageName(), R.layout.main);
	      
	         Bitmap myBitmap = Bitmap.createBitmap(250,40, Bitmap.Config.ARGB_4444);
	         Bitmap myBitmap2 = Bitmap.createBitmap(250,40, Bitmap.Config.ARGB_4444);
	         Bitmap myBitmap3 = Bitmap.createBitmap(250,40, Bitmap.Config.ARGB_4444);
			 Canvas myCanvas = new Canvas(myBitmap);
			 Canvas myCanvas2 = new Canvas(myBitmap2);
			 Canvas myCanvas3 = new Canvas(myBitmap3);
			 Paint paint = new Paint();         
			 Typeface clock = Typeface.createFromAsset(context.getAssets(),"ALKATIP Tor.TTF");         
			 paint.setAntiAlias(true);         
			 paint.setSubpixelText(true);         
			 paint.setTypeface(clock);
			 paint.setStyle(Paint.Style.FILL);        
			 paint.setColor(Color.WHITE);         
			 paint.setTextSize(30);        
		     myCanvas.drawText(ArabicReshape.reshape_reverse(reverse(hepte)),70, 30, paint);    
		     myCanvas2.drawText(ArabicReshape.reshape_reverse(reverse(ay_uy)),130,25, paint);
		     myCanvas3.drawText(ArabicReshape.reshape_reverse(reverse(ay_eng)),20,30, paint);
			 updateViews.setImageViewBitmap(R.id.imhepte, myBitmap); 
		     updateViews.setTextViewText(R.id.txtkun,kunn);
			 updateViews.setTextViewText(R.id.txtyil,yill);
			 updateViews.setImageViewBitmap(R.id.imayy_uy, myBitmap2); 
			 updateViews.setImageViewBitmap(R.id.imay_eng, myBitmap3); 
			 
			
	         appWidgetManager.updateAppWidget(appWidgetIds, updateViews);
	         super.onUpdate(context, appWidgetManager, appWidgetIds); 
	     
	   }
	
	private String reverse(String lineString) {
		// TODO Auto-generated method stub
		String line = "";
		for(int l=0; l<lineString.length();l++){
			line += lineString.charAt(lineString.length()-l-1);
		}
		return line;
	}
	
	}