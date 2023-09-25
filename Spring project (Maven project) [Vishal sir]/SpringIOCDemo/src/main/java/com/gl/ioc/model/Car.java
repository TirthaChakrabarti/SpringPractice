package com.gl.ioc.model;

public class Car {

	private String modelName;
	private Engine engine;

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(String modelName, Engine engine) {
		super();
		this.modelName = modelName;
		this.engine = engine;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@Override
	public String toString() {
		return "Car [modelName=" + modelName + ", engine=" + engine + "]";
	}

}
