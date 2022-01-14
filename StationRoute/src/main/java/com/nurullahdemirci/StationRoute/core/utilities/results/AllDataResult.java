package com.nurullahdemirci.StationRoute.core.utilities.results;

import java.util.ArrayList;
import java.util.List;

public class AllDataResult<T> {
	private List<DataResult<T>> dataResult;
	private List<Result> result;
	private boolean error;
	
	public AllDataResult() {
		this.dataResult = new ArrayList<DataResult<T>>();
		this.result=new ArrayList<Result>();
		this.error=true;
	}
	
	public void addResult(DataResult<T> dataResult) {
		this.dataResult.add(dataResult);
		if(dataResult.getSuccess()==false)
			this.error=false;
	}
	
	public void addResult(Result result) {
		this.result.add(result);
		if(result.getSuccess()==false)
			this.error=false;
	}
	
	public Boolean getSuccess() {
		return this.error;
	}
	
	public List<DataResult<T>> getDataResults(){
		return this.dataResult;
	}
	
	public List<Result> getResults(){
		return this.result;
	}
	
	public List<DataResult<T>> getSuccessDataResults(){
		List<DataResult<T>> successDataResult=new ArrayList<DataResult<T>>();
		for(DataResult<T> dataResult:this.dataResult) {
			if(dataResult.getSuccess())
				successDataResult.add(dataResult);
		}
		return successDataResult;
	}
	
	public List<Result> getSuccessResults(){
		List<Result> successResult=new ArrayList<Result>();
		for(Result result:this.result) {
			if(result.getSuccess())
				successResult.add(result);
		}
		return successResult;
	}
	
	public List<DataResult<T>> getErrorDataResults(){
		List<DataResult<T>> errordataResult=new ArrayList<DataResult<T>>();
		for(DataResult<T> dataResult:this.dataResult) {
			if(!dataResult.getSuccess())
				errordataResult.add(dataResult);
		}
		return errordataResult;
	}
	
	public List<Result> getErrorResults(){
		List<Result> errorResult=new ArrayList<Result>();
		for(Result result:this.result) {
			if(!result.getSuccess())
				errorResult.add(result);
		}
		return errorResult;
	}
}
