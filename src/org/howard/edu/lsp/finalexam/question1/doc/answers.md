# Question 1

#Part 1:

Shared Resource #1:
nextId is a shared mutable resource because multiple threads may read and update it.

Shared Resource #2:
requests is a shared mutable ArrayList because multiple threads may add requests to it.

Concurrency Problem:
A race condition may occur. Two threads could read the same nextId before either update is completed, which could create duplicate request IDs. The shared ArrayList may also be updated unsafely by multiple threads.

Why addRequest() is unsafe:
addRequest() is unsafe because it calls getNextId(), creates the request, and adds it to the shared list without protecting the whole operation. Multiple threads can interleave during those steps.

Part 2:

Fix A:
Not correct. Synchronizing getNextId() protects only the ID generation, but requests.add(request) is still unsafe because ArrayList is shared and not thread-safe.

Fix B:
Correct. Synchronizing addRequest() protects the entire critical section: getting the ID, creating the request string, and adding it to the shared list. Only one thread can execute addRequest() at a time.

Fix C:
Not correct. Synchronizing getRequests() only protects access when retrieving the list. It does not protect ID generation or adding requests.

Part 3:

No, getNextId() should not be public. Based on Arthur Riel’s heuristics, internal implementation details should be hidden. The request ID is part of how RequestManager manages requests internally, so outside classes should not call getNextId() directly.

Part 4:

Description:
An alternative approach is to use a ReentrantLock. 
The lock can be acquired before the critical section in addRequest() and released afterward. 
This makes sure only one thread at a time can generate the ID and add the request.

Code Snippet:
```java
private final ReentrantLock lock = new ReentrantLock();

public void addRequest(String studentName) {
    lock.lock();
    try {
        int id = getNextId();
        String request = "Request-" + id + " from " + studentName;
        requests.add(request);
    } finally {
        lock.unlock();
    }
}