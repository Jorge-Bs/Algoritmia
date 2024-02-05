from time import time

def isPrimo(numero,listaPrimos):
    for i in listaPrimos:
        if(numero%i==0):
            return False
    return True

def listaPrimos(cantidadDeNumeros):
    listaDePrimos=[]
    listaDePrimos.append(2)
    for i in range(3,cantidadDeNumeros+1):
        if(isPrimo(i,listaDePrimos)):
            listaDePrimos.append(i)
    
    return listaDePrimos

def main():
    n=10000
    for i in range(8):
        t1 = time()
        listaPrimos(n)
        t2= time()-t1
        print(f"El tiempo para {n} elementos, ha sido de {int(1000*t2)} milisegundos")
        n*=2

main()
