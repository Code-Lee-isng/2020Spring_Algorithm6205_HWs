# Errors made

1. List<Integer>, contents added in it is Objects while num > 2^7; so, while compare two elements, DO NOT use "==", use equals.

2. int + int might be over flow, so while do PLUS, we can temporarily extend its type, like "long".

# Tips

Don't turn it into negative number. Some languages don't support signed values.

Solution one, is a very good way to use recursion without converting it into negative numbers.
