# Assignment 7: Intro to Algorithms
# Jayden Cruz

library(rethinking)
library(ggdag)
library(ggplot2)
library(rlang) 
# Define the input
input <- "[ (I, 2), (A, 5), (E, 4), (F, 2), (T, 2), (S, 3) ]"

vertices <- c("I", "A", "E", "F", "T", "S")
distances <- c(2, 5, 4, 2, 2, 3)
n <- length(vertices)

edges <- list()

for (i in 1:n) {
  v <- vertices[i]
  x <- distances[i]
  
  right_index <- ((i + x - 1) %% n) + 1 
  left_index <- ((i - x - 1 + n) %% n) + 1
  
  right_vertex <- vertices[right_index]
  left_vertex <- vertices[left_index]
  
  edges <- append(edges, expr(!!sym(right_vertex) ~ !!sym(v)))
  edges <- append(edges, expr(!!sym(left_vertex) ~ !!sym(v)))
}

dag_obj <- eval(expr(dagify(!!!edges)))

# Plot
ggdag(dag_obj) +
  theme_dag() +
  ggtitle("Directed Graph Visualization")
