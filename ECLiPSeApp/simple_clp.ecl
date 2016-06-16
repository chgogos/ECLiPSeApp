:- use_module(library(ic)).

solve_clp(X,Y,Z) :- 
	[X,Y] #:: [1..10],
	Z #:: [4..11],
	X #>3, X #<9,
	Y #>2, Y #<9,
	X #= Y+1,
	Z #> 5, Z #< X,
	labeling([X,Y,Z]).
	
  