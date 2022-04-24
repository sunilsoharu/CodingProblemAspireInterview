package com.aspireapp.baseframework;

public class NoCorrectDriverFoundException extends RuntimeException{

	 		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public NoCorrectDriverFoundException(String message) {
			super(message);
		}
		
		public NoCorrectDriverFoundException(){
			this("");
		}

	}

