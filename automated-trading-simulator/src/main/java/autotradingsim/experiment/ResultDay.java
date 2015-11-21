package autotradingsim.experiment;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import autotradingsim.strategy.IDecision;

public class ResultDay {
	private List<IDecision> decisions;
	private LocalDate date;
	private BigDecimal openingBalance;
	private BigDecimal closingBalance;
	
	public ResultDay(LocalDate date,  
			BigDecimal openingBalance, 
			BigDecimal closingBalance) {
		this.decisions = new ArrayList<IDecision>();
		this.date = date;
		this.openingBalance = openingBalance;
		this.closingBalance = closingBalance;
	}
	
	public ResultDay(LocalDate date, 
					List<IDecision> decisions, 
					BigDecimal openingBalance, 
					BigDecimal closingBalance) {
		this.decisions = decisions;
		this.date = date;
		this.openingBalance = openingBalance;
		this.closingBalance = closingBalance;
	}
	
	public BigDecimal getBalanceRelativeChange(){
    	return this.getOpeningBalance().subtract(this.getClosingBalance());
    }
    
    public LocalDate getDate(){
    	return this.date;
    }
    
    public void setClosingDate(BigDecimal closingBalance){
    	this.closingBalance = closingBalance;
    }
    
    public List<IDecision> getDecisions(){
    	return this.decisions;
    }
    
    public void addDecision(IDecision decision){
    	this.decisions.add(decision);
    }
    
    public BigDecimal getOpeningBalance(){
    	return this.openingBalance;
    }
    
    public BigDecimal getClosingBalance(){
    	return this.closingBalance;
    }

}
