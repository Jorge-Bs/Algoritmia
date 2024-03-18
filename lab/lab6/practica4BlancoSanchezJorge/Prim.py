from heapq import *
from Auxiliar import matrizTriangularDesdeFichero,matrizTriangularEnterosAleatorios
from time import time

def prim(matriz,indice):
    visitados=[]
    heap=[]
    contador=1
    resultado=[]
    for i in range(len(matriz)):
        visitados.append([i,0])
    visitados[indice][1]=1 

    addHeap(heap,indice,matriz,visitados)

    while(contador<len(matriz)):
        elemento=heappop(heap)

        if(visitados[elemento[2]][1]==0):
            resultado.append(elemento)
            visitados[elemento[2]][1]=1
            addHeap(heap,elemento[2],matriz,visitados)
            contador+=1

    return resultado
    
def addHeap(heap,indice,matriz,visitados):
    for i in range(len(matriz)):
        if(i>indice and visitados[i][1]==0):
            heappush(heap,[matriz[indice][i],indice,i])
        if(i<indice and visitados[i][1]==0):
            heappush(heap,[matriz[i][indice],indice,i])

def sumaCoste(lista):
    suma=0
    for i in lista:
        suma+=i[0]
    print(f"La suma de los costes es: {suma}")


def tomaTiempos():
    i=256
    while(i<=8192):
        ##t0=time()
        m=matrizTriangularEnterosAleatorios(i,0,10000)
        ##t3=time()
        ##print(f"\tTiempo de creacion de la matriz: {t3-t0}")
        t1 = time()
        prim(m,0)
        t2 = time()
        print(f"El tiempo para tamaño {i} es de: {t2-t1} segundos")
        m=0
        i*=2

def prueba():
    m=matrizTriangularDesdeFichero("grafo8.txt")

    a=prim(m,0)
    print(a)
    sumaCoste(a)

tomaTiempos()
i=10000
for j in range(2):
    m=matrizTriangularEnterosAleatorios(i,0,10000)
    t1 = time()
    prim(m,0)
    t2 = time()
    print(f"El tiempo para tamaño {i} es de: {t2-t1} segundos")
    i+=2000
