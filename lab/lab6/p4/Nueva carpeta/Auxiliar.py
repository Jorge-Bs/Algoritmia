import random
import math
from heapq import *
from time import time


def crearMatriz(n,valor):
    """Crea en memoria principal una matriz
    cuadrada de orden n, con elementos igual
    a valor.
    Al final retorna dicha matriz  """
    m=[]
    for i in range(n):
        m.append(n*[valor])
    return m


def escribirMatriz(m):
    """Recibe una matriz y la escribe por
    pantalla de forma clásica"""
    for i in range(len(m)):
        for j in range(len(m)):
            print(m[i][j],end="\t")
        print()
    print()

##m=crearMatriz(16,0)
##escribirMatriz(m)



def matrizTriangularEnterosAleatorios(n,inf,sup):
    """Genera y devuelve una matriz triangular (i<j) de
    orden n, con enteros aleatorios entre [inf..sup]"""
    m=crearMatriz(n,0)
    for i in range(n):
        for j in range(i+1,n):
            m[i][j]=random.randint(inf,sup)
    return m

##m=matrizTriangularEnterosAleatorios(16,100,999)
##escribirMatriz(m)


def matrizTriangularDesdeFichero(fich):
    """Genera un matriz triangular (i<j) que lee
    desde un fichero de entrada, con formato visto"""
    fi=open(fich,"r")
    n=int(fi.readline())
#    print(n)
    m=crearMatriz(n,0)
#    escribirMatriz(m)
    i=0
    for linea in fi:
        lista=linea.strip().split(",")
#        print(lista)
        k=0
        for j in range(i+1,n):
            m[i][j]=int(lista[k])
            k=k+1
        i=i+1
    fi.close()
    return(m)

m=matrizTriangularDesdeFichero("grafo8.txt")
##escribirMatriz(m)


def prim(matriz):
    visitados=[]
    aristas=[]
    visitados.append(0)
    return primRecu(matriz,visitados,aristas)

def primRecu(matriz,visitado,aristas):
    if(len(visitado)==len(matriz)):
        return aristas
    else:
        costemin=math.inf
        arista=[]
        for i in visitado:
            for j in range(len(matriz)):
                if (i>=j): continue
                else:
                    if (matriz[i][j]<costemin and j not in visitado):
                        costemin=matriz[i][j]
                        arista=(i,j)
    visitado.append(arista[1])
    aristas.append(arista)
    return primRecu(matriz,visitado,aristas)

##t1= time()
##i=256
while(False):
    t1= time()
    m= matrizTriangularEnterosAleatorios(i,1,1000000)
    prim(m)
    t2 = time()
    print(f"El tiempo para {i} elementos es de {t2-t1}")
    i*=2

##print(m[0][1],m[1][2],m[1][3])

def prim1(matriz):
    h=[]
    min=math.inf
    arista=()
    for i in range(len(matriz)):
        for j in range(len(matriz)):
            if(i>=j): continue
            if(matriz[i][j]<min):
                min=matriz[i][j]
                arista=(i,j)
        if(min!=math.inf):
            h.append((arista,min))
            min=math.inf
    return h

print(prim1(m))
        
i=256
while(False):
    m= matrizTriangularEnterosAleatorios(i,1,1000000)
    t1= time()
    prim1(m)
    t2 = time()
    print(f"El tiempo para {i} elementos es de {t2-t1}")
    i*=2













