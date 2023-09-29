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

		if (lookahead.getType() != 0) {
			throw new ParserException("Unexpected symbol " + lookahead.getLexeme() + "  found");
		}
	}

	private void nextToken() {
		System.out.print("Proximo: " + tokens.getFirst().getLexeme());

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
		if (lookahead.getType() == 1) {
			nextToken();
			if (lookahead.getType() == 9) {
				nextToken();
				if (lookahead.getType() == 17) {
					nextToken();
				}
			}
		}
	}

	private void modelFamily() {
		if (lookahead.getType() == 2) {
			nextToken();
			if (lookahead.getType() == 9) {
				nextToken();
				modelFamilyName();
			}
		} else {

		}
	}

	private void modelFamilyName() {
		if (lookahead.getType() == 26) {
			nextToken();
		} else if (lookahead.getType() == 27) {
			nextToken();
		} else if (lookahead.getType() == 28) {
			nextToken();
		}
	}

	private void modelType() {
		if (lookahead.getType() == 3) {
			nextToken();
			if (lookahead.getType() == 9) {
				nextToken();
				modelTypeName();
			}
		}
	}

	private void modelTypeName() {
		if (lookahead.getType() == 21) {
			nextToken();
		} else if (lookahead.getType() == 22) {
			nextToken();
		} else if (lookahead.getType() == 23) {
			nextToken();
		} else if (lookahead.getType() == 24) {
			nextToken();
		} else if (lookahead.getType() == 25) {
			nextToken();
		}
	}

	private void modelDescription() {
		if (lookahead.getType() == 4) {
			nextToken();
			if (lookahead.getType() == 9) {
				nextToken();
				if (lookahead.getType() == 17) {
					nextToken();
				}
			}
		} else {

		}
	}

	private void inputs() {
		if (lookahead.getType() == 5) {
			nextToken();
			if (lookahead.getType() == 11) {
				nextToken();
				inputList();
				if (lookahead.getType() == 12) {
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
		if (lookahead.getType() == 6) {
			nextToken();
			if (lookahead.getType() == 11) {
				nextToken();
				inputName();
				inputType();
				if (lookahead.getType() == 12) {
					nextToken();
				}
			}
		}
	}

	private void inputName() {
		if (lookahead.getType() == 7) {
			nextToken();
			if (lookahead.getType() == 9) {
				nextToken();
				if (lookahead.getType() == 17) {
					nextToken();
				}
			}
		}
	}

	private void inputType() {
		if (lookahead.getType() == 8) {
			nextToken();
			if (lookahead.getType() == 9) {
				nextToken();
				inputTypeName();
			}
		}
	}

	private void inputTypeName() {
		if (lookahead.getType() == 18) {
			nextToken();
		} else if (lookahead.getType() == 19) {
			nextToken();
		} else if (lookahead.getType() == 20) {
			nextToken();
		}
	}

	private void a() {
		if (lookahead.getType() != 0) {
			input();
			a();
		} else {

		}
	}

	private void outputs() {
		if (lookahead.getType() == 13) {
			nextToken();
			if (lookahead.getType() == 11) {
				nextToken();
				outputList();
				if (lookahead.getType() == 12) {
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
		if (lookahead.getType() == 14) {
			nextToken();
			if (lookahead.getType() == 11) {
				nextToken();
				outputName();
				outputType();
				if (lookahead.getType() == 12) {
					nextToken();
				}
			}
		}
	}

	private void outputName() {
		if (lookahead.getType() == 15) {
			nextToken();
			if (lookahead.getType() == 9) {
				nextToken();
				if (lookahead.getType() == 17) {
					nextToken();
				}
			}
		}
	}

	private void outputType() {
		if (lookahead.getType() == 16) {
			nextToken();
			if (lookahead.getType() == 9) {
				nextToken();
				outputTypeName();
			}
		}
	}

	private void outputTypeName() {
		if (lookahead.getType() == 18) {
			nextToken();
		} else if (lookahead.getType() == 19) {
			nextToken();
		} else if (lookahead.getType() == 20) {
			nextToken();
		}
	}

	private void b() {
		if (lookahead.getType() != 0) {
			output();
			a();
		} else {

		}
	}

	private void model() {
		if (lookahead.getType() == 29) {
			nextToken();
			if (lookahead.getType() == 11) {
				nextToken();
				layersList();
				if (lookahead.getType() == 12) {
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
		if (lookahead.getType() != 0) {
			layers();
			e();
		} else {

		}
	}

	private void layers() {
		if (lookahead.getType() == 30) {
			nextToken();
			if (lookahead.getType() == 11) {
				nextToken();
				layerList();
				if (lookahead.getType() == 12) {
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
		if (lookahead.getType() == 31) {
			nextToken();
			if (lookahead.getType() == 11) {
				nextToken();
				layerName();
				layerParams();
				if (lookahead.getType() == 12) {
					nextToken();
				}
			}
		}
	}

	private void layerName() {
		if (lookahead.getType() == 32) {
			nextToken();
			if (lookahead.getType() == 9) {
				nextToken();
				if (lookahead.getType() == 17) {
					nextToken();
				}
			}
		}
	}

	private void layerParams() {
		if (lookahead.getType() == 33) {
			nextToken();
			if (lookahead.getType() == 9) {
				nextToken();
				if (lookahead.getType() == 34) {
					nextToken();
					numbers();
					if (lookahead.getType() == 35) {
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
		if (lookahead.getType() == 19) {
			nextToken();
			if (lookahead.getType() == 10) {
				nextToken();
			}
		} else if (lookahead.getType() == 19) {
			nextToken();
		}
	}

	private void d() {
		if (lookahead.getType() != 0) {
			number();
			d();
		} else {

		}
	}

	private void c() {
		if (lookahead.getType() != 0) {
			layer();
			c();
		} else {

		}
	}
}
