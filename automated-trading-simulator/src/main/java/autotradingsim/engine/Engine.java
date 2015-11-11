package autotradingsim.engine;
import autotradingsim.application.*;
import autotradingsim.strategy.*;

import autotradingsim.strategy.ICondition.Comparator;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import autotradingsim.experiment.*;
import autotradingsim.strategy.simpleimpl.*;
import autotradingsim.terminal.*;
public class Engine {

	public TradingApplication TradingSimApp = TradingApplication.getInstance();
	private Engine(){
		
	}
	
}
