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
    m=crearMatriz(n,math.inf)
    for i in range(n):
        for j in range(i+1,n):
            value=random.randint(inf,sup)
            m[i][j]=value
            m[j][i]=value
    return m

##m=matrizTriangularEnterosAleatorios(16,100,999)
##escribirMatriz(m)


def matrizTriangularDesdeFichero(fich):
    """Genera un matriz triangular (i<j) que lee
    desde un fichero de entrada, con formato visto"""
    fi=open(fich,"r")
    n=int(fi.readline())
#    print(n)
    m=crearMatriz(n,math.inf)
#    escribirMatriz(m)
    i=0
    for linea in fi:
        lista=linea.strip().split(",")
#        print(lista)
        k=0
        for j in range(i+1,n):
            m[i][j]=int(lista[k])
            m[j][i]=int(lista[k])
            k=k+1
        i=i+1
    fi.close()
    return(m)

m=matrizTriangularDesdeFichero("grafo16.txt")
#escribirMatriz(m)


def prim(matriz):
    visitados=[]
    aristas=[]
    for i in range(len(matriz)):
        visitados.append([i,0])
    visitados[0][1]=1
    nodos=[]
    contador=1
    ##print(visitados)
    return primRecu(matriz,visitados,aristas,contador)

def primRecu(matriz,visitado,aristas,contador):
    if(contador==len(matriz)):
        return aristas
    else:
        costemin=math.inf
        arista=[]
        for i in range(len(matriz)):
            if(visitado[i][1]!=1): continue
            for j in range(len(matriz)):
                if (i>=j): continue
                else:
                    if (matriz[i][j]<costemin and visitado[j][1]!=1):
                        costemin=matriz[i][j]
                        arista=(i,j)
                        matriz[i][j]=math.inf
    if(len(arista)!=0):
        visitado[arista[1]][1]=1
        aristas.append(arista)
    contador+=1
    return primRecu(matriz,visitado,aristas,contador)

#print(prim(m))
##print(m[0][1],m[1][2],m[1][3])

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
                matriz[i][j]=math.inf
        if(min!=math.inf):
            h.append((arista,min))
            min=math.inf
    return h

#print(prim1(m))
        
i=256
while(False):
    m= matrizTriangularEnterosAleatorios(i,1,1000000)
    t1= time()
    prim1(m)
    t2 = time()
    print(f"El tiempo para {i} elementos es de {t2-t1}")
    i*=2



def prim2(matriz):
    arista=[]
    contador=1

    for i in range(len(matriz)):
        min=math.inf
        ar=[]
        for j in range(len(matriz)):
            #if(i>=j): continue
            if(matriz[i][j]<=min):
                min=matriz[i][j]
                ar.append((i,j,min))
                matriz[i][j]=math.inf
                matriz[j][i]=math.inf
        for k in range(len(ar)-1,-1,-1):
            if(ar[k][2]==min):
                arista.append(ar[k])
        min=math.inf
    return arista

def filtrado(lista,lon):
    h=[]
    visitados=[]
    contador=1
    resultado=[]
    for i in range(lon):
        visitados.append([i,0])
    visitados[0][1]=1
    for i in lista:
        heappush(h,i)
    while(lon!=contador):
        value=heappop(h)
        if (visitados[value[0]][1]==1 and visitados[value[1]][1]==0):
            resultado.append(value)
            visitados[value[1]][1]=1
            contador+=1
        if(visitados[value[0]][1]==0 and visitados[value[1]][1]==1):
            resultado.append(value)
            visitados[value[0]][1]=1
            contador+=1
            
    return resultado

    


def sumaCoste(lista):
    suma=0
    for i in lista:
        suma+=i[2]
    print(suma)

#print(m[10])
k=prim2(m)
h=filtrado(k,len(m))
print(h)
sumaCoste(h)



i=256
while(False):
    m= matrizTriangularEnterosAleatorios(i,1,1000000)
    t1= time()
    filtrado(prim2(m))
    t2 = time()
    print(f"El tiempo para {i} elementos es de {t2-t1}")
    i*=2




