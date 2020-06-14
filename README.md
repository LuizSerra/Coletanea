# Coletanea
Um projeto realizado em Android Nativo.

A aplicação tem por objetivo servir como uma coletânea virtual.
As músicas são carregadas em tela a partir de um arquivo XML. 
# Telas pequenas e tablets modo portrait:
O usuário primeiramente vê a lista com os títulos das canções. Ao clicar na em uma desses títulos da lista, o usuário é então direcionado para uma outra tela (activity) em que é mostrada a canção inteira com título e letra.

# Tablets modo landscape:
Nesse modo a tela é exibida divida em duas seções. À esquerda, a lista com o título das canções e à direita a área reservada a exibir a canção selecionada com título e letra.

Para reproduzir o comportamento descrito acima, onde a aplicação apresenta layouts diferentes de acordo com o tamanho da tela disponível, foi utilizada a biblioteca Fragments do Android, permitindo reorganizar os fragments de acordo com a necessidade.
