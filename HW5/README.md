# errors

1. List<Integer>, contents added in it is Objects while num > 2^7; so, while compare two elements, DO NOT use "==", use equals.

2. int + int might be over flow, so while do PLUS, we can temporarily extend its type, like "long".
