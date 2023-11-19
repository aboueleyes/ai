food(1).
materials(0).
energy(2).
build1(1,2,1).
build2(4,1,2).

can_build(F, M, E, s0) :-
    build1(F1, M1, E1),
    F >= F1,
    M >= M1,
    E >= E1.

can_build(F, M, E, s0) :-
    build2(F1, M1, E1),
    F >= F1,
    M >= M1,
    E >= E1.

can_build(F, M, E, result(reqF, S)):-
    F1 is F + 1,
    can_build(F1, M, E, S).

can_build(F, M, E, result(reqM, S)):-
    M1 is M + 1,
    can_build(F, M1, E, S).

can_build(F, M, E, result(reqE, S)):-
    E1 is E + 1,
    can_build(F, M, E1, S).

can_build(F, M, E, result(_, S)):-
    can_build(F, M, E, S).


goal(result(A, S)) :-
    food(F),
    materials(M),
    energy(E),
    can_build(F, M, E, S),
    A = b1.

ids(X,L):-
(call_with_depth_limit(goal(X),L,R), number(R));
(call_with_depth_limit(goal(X),L,R), R=depth_limit_exceeded,
L1 is L+1, ids(X,L1)).
