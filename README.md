# A7 Linked Lists

Your readme should include the following information. **Each student** needs to submit all of this information, even when pair programming. 

## Submission Details

Programming Partner Name (if you are submitting identical code):
No.

Other Collaborators (submitting related but non-identical code):
No.

Kudos/shout-out to particularly helpful members of the class or teaching staff:
TAs.

Any references used besides JavaDoc and course materials:
Course Material: PPT 13-List-Operations
https://www.geeksforgeeks.org/advantages-and-disadvantages-of-linked-list/

If you used AI, please describe how and the interaction between AI and your understanding of this assignment and specifically the related data structures and algorithms:

## Reflection

What do you see as the benefits and downsides of working with linked lists instead of arrays? When might they be most useful versus limiting?
Advantages of linked lists would be: no memory wastage (as the size of the linked list increase or decrease with run time so there is no need to pre-allocate the memory); can be used to implement stacks and queues; insertion and deletion operations are more efficient (with constant operation time)
Disadvantages would be: memory usage (more memory is required in the linked list as compared to an array, as pointers also require additional memories); traversal (more time-consuming compared to an array as linked list cannot have direct access to an element); random access is not possible in a linked list due to its dynamic memory allocation.
I think linked lists might be more useful if you want to implement a data structure with insertions and deletions.

What was the major challenge you faced in completing this assignment?
It's challenging but meaningful to think through the methods spliceByCopy() and subseqByTransfer().

What do you feel you learned from this assignment?
I think I've learned to think more carefully about copy and transfer methods (than in the array sections).