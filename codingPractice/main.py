
from queue import Queue 
  
def generateNumbersUtil(): 
    global vec 
      
    # Create an empty queue of strings  
    q = Queue() 
          
    # enque the first number  
    q.put("9")  
      
    for count in range(MAX_COUNT, -1, -1): 
        s1 = q.queue[0]  
        q.get() 
          
        vec.append(s1)  
          
        s2 = s1  
          
        s1 += "0"
        q.put(s1)  

        s2 += "9"
        q.put(s2) 

def findSmallestMultiple(n): 
    global vec 
      
    for i in range(len(vec)): 
        if (int(vec[i]) % n == 0):  
            return vec[i]  
  
MAX_COUNT = 10000
vec = []  
generateNumbersUtil()
print((vec[1:10]))   
# n = 7    
# print(findSmallestMultiple(n)) 
  