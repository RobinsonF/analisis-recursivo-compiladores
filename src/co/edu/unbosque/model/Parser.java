package co.edu.unbosque.model;

import java.util.LinkedList;
import java.util.List;

public class Parser {
	private LinkedList<Token> tokens;
	private Token lookahead;

	public void parse(List<Token> tokens) {

		this.tokens = new LinkedList<>();
		for (int i = 0; i < tokens.size(); i++) {
			this.tokens.add(tokens.get(i).clone());
		}

		lookahead = this.tokens.getFirst();

		document();

		if (lookahead.token != 0) {
			throw new ParserException("Unexpected symbol " + lookahead.lexeme + "  found");
		}
	}

	private void nextToken() {
		System.out.print("Proximo: " + tokens.getFirst().lexeme);

		tokens.pop();
		if (tokens.isEmpty()) {
			lookahead = new Token(0, "", -1);
		} else {
			lookahead = tokens.getFirst();
		}
	}

	private void document() {
		modelName();
		modelFamily();
		modelType();
		modelDescription();
		inputs();
		outputs();
		model();
	}

	private void modelName() {
		if (lookahead.token == 1) {
			nextToken();
			if (lookahead.token == 9) {
				nextToken();
				if (lookahead.token == 17) {
					nextToken();
				}
			}
		}
	}

	private void modelFamily() {
		if (lookahead.token == 2) {
			nextToken();
			if (lookahead.token == 9) {
				nextToken();
				modelFamilyName();
			}
		} else {

		}
	}
	
	private void modelFamilyName() {
		if (lookahead.token == 26) {
			nextToken();
		}else if (lookahead.token == 27) {
			nextToken();
		} else if (lookahead.token == 28) {
			nextToken();
		}
	}
	
	private void modelType() {
		if (lookahead.token == 3) {
			nextToken();
			if (lookahead.token == 9) {
				nextToken();
				modelTypeName();
			}
		}
	}
	
	private void modelTypeName() {
		if (lookahead.token == 21) {
			nextToken();
		}else if (lookahead.token == 22) {
			nextToken();
		} else if (lookahead.token == 23) {
			nextToken();
		}else if (lookahead.token == 24) {
			nextToken();
		}else if (lookahead.token == 25) {
			nextToken();
		}
	}

	private void modelDescription() {
		if (lookahead.token == 4) {
			nextToken();
			if (lookahead.token == 9) {
				nextToken();
				if (lookahead.token == 17) {
					nextToken();
				}
			}
		} else {

		}
	}

	private void inputs() {
		if (lookahead.token == 5) {
			nextToken();
			if (lookahead.token == 11) {
				nextToken();
				inputList();
				if (lookahead.token == 12) {
					nextToken();
				}
			}
		}
	}

	private void inputList() {
		input();
		a();
	}
	
	private void input() {
		if (lookahead.token == 6) {
			nextToken();
			if (lookahead.token == 11) {
				nextToken();
				inputName();
				inputType();
				if (lookahead.token == 12) {
					nextToken();
				}
			}
		}
	}
	
	private void inputName() {
		if (lookahead.token == 7) {
			nextToken();
			if (lookahead.token == 9) {
				nextToken();
				if (lookahead.token == 17) {
					nextToken();
				}
			}
		}
	}
	
	private void inputType() {
		if (lookahead.token == 8) {
			nextToken();
			if (lookahead.token == 9) {
				nextToken();
				inputTypeName();
			}
		}
	}
	
	private void inputTypeName() {
		if (lookahead.token == 18) {
			nextToken();
		}else if (lookahead.token == 19) {
			nextToken();
		} else if (lookahead.token == 20) {
			nextToken();
		}
	}
	
	private void a() {
		if (lookahead.token != 0) {
			input();
			a();
		}else {
			
		}
	}
	
	private void outputs() {
		if (lookahead.token == 13) {
			nextToken();
			if (lookahead.token == 11) {
				nextToken();
				outputList();
				if (lookahead.token == 12) {
					nextToken();
				}
			}
		}
	}
	
	private void outputList() {
		output();
		b();
	}

	private void output() {
		if (lookahead.token == 14) {
			nextToken();
			if (lookahead.token == 11) {
				nextToken();
				outputName();
				outputType();
				if (lookahead.token == 12) {
					nextToken();
				}
			}
		}
	}
	
	private void outputName() {
		if (lookahead.token == 15) {
			nextToken();
			if (lookahead.token == 9) {
				nextToken();
				if (lookahead.token == 17) {
					nextToken();
				}
			}
		}
	}
	
	private void outputType() {
		if (lookahead.token == 16) {
			nextToken();
			if (lookahead.token == 9) {
				nextToken();
				outputTypeName();
			}
		}
	}
	
	private void outputTypeName() {
		if (lookahead.token == 18) {
			nextToken();
		}else if (lookahead.token == 19) {
			nextToken();
		} else if (lookahead.token == 20) {
			nextToken();
		}
	}
	
	private void b() {
		if (lookahead.token != 0) {
			output();
			a();
		}else {
			
		}
	}
	
	private void model() {
		if (lookahead.token == 29) {
			nextToken();
			if (lookahead.token == 11) {
				nextToken();
				layersList();
				if (lookahead.token == 12) {
					nextToken();
				}
			}
		}
	}
	
	private void layersList() {
		layers();
		e();
	}
	
	private void e() {
		if (lookahead.token != 0) {
			layers();
			e();
		}else {
			
		}
	}
	
	private void layers() {
		if (lookahead.token == 30) {
			nextToken();
			if (lookahead.token == 11) {
				nextToken();
				layerList();
				if (lookahead.token == 12) {
					nextToken();
				}
			}
		}
	}
	
	private void layerList() {
		layer();
		c();
	}
	
	private void layer() {
		if (lookahead.token == 31) {
			nextToken();
			if (lookahead.token == 11) {
				nextToken();
				layerName();
				layerParams();
				if (lookahead.token == 12) {
					nextToken();
				}
			}
		}
	}
	
	private void layerName() {
		if (lookahead.token == 32) {
			nextToken();
			if (lookahead.token == 9) {
				nextToken();
				if (lookahead.token == 17) {
					nextToken();
				}
			}
		}
	}
	
	private void layerParams() {
		if (lookahead.token == 33) {
			nextToken();
			if (lookahead.token == 9) {
				nextToken();
				if (lookahead.token == 34) {
					nextToken();
					numbers();
					if (lookahead.token == 35) {
						nextToken();						
					}
				}
			}
		}
	}
	
	private void numbers() {
		number();
		d();
	}
	
	private void number() {
		if (lookahead.token == 19) {
			nextToken();	
			if (lookahead.token == 10) {
				nextToken();	
			}
		}else if (lookahead.token == 19){
			nextToken();	
		}
	}
	
	private void d() {
		if (lookahead.token != 0) {
			number();
			d();
		}else {
			
		}
	}
	
	private void c() {
		if (lookahead.token != 0) {
			layer();
			c();
		}else {
			
		}
	}
}
