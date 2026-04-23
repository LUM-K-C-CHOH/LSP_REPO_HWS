Heuristic 1:
H2.1 — All data should be hidden within its class.
Explanation:
This improves readability and maintainability through encapsulation by keeping internal data private and exposing only controlled behavior through methods. In lecture, this was illustrated with private fields and stable public interfaces so internal changes do not ripple through the system.

Heuristic 2:
H3.1 — Distribute system intelligence horizontally as uniformly as possible.
Explanation:
Responsibilities should be shared among collaborating classes instead of concentrated in one controlling class. In lecture this was explained as avoiding centralized action-oriented design and “god classes,” making systems more modular, flexible, and easier to maintain.

Heuristic 3:
H2.6 — Do not clutter the public interface of a class with things users do not need.
Explanation:
This improves maintainability by hiding implementation details and minimizing unnecessary public operations. In lecture this was tied to keeping interfaces simple, reducing coupling, and exposing behavior clients need rather than internal implementation details.
