# Giggin

## 01 Dev Setup
**ClojureScript**

`Reagent` - Interface entre o ClojureScript e o React.

`shadow-cljs` - Compila CLSJ, integra npm/node_modules e gerencia builds.

`Node.js` - ambiente de execução JS (runtime).

**CLJS -> shadow-cljs (node) -> JS -> Browser**

## 02 App Setup
[Código inicial do projeto](https://github.com/jacekschae/learn-reagent-course-files)

`giggin` - Projeto

`increments` - Soluções

Clonar o projeto:

```
git clone https://github.com/jacekschae/learn-reagent-course-files.git
```

Dentro do diretório 'giggin', baixar as dependências do ecossistema npm:

```
npm install
```

Baixar todas as dependências do ecossistema do Clojure/Script:

```
npx shadow-cljs watch app
```

**Diretórios:**

`node_modules` - Diretório onde o Node.js instala as dependências JavaScript listadas no 'packge.jsoni'.

`public` - Contém todos os arquivos estáticos que o browser pode acessar diretamente.

`src` - Contém todo o código fonte a ser compilado pelo shadow-cljs.

**Arquivos:**

`index.html` - Será o primeiro arquivo à ser lido pelo servidor.

`shadow-cljs.edn` - Dependências ClojureScript.

`package.json` - Dependências JavaScript. (ecossistema npm)

`package-lock.json` - Mantém 'congeladas' exatamente quais versões de todas as dependências JS que foram instaladas.

**Hiccup Syntax**
```clojure
;; classe
(defn app
  "<div class=\"container\"></div>"
  []
  [:div.container])
;; ou
(defn app
  "<div class=\"container\"></div>"
  []
  [:div {:class "container"}])

;; id
(defn app
  "<div id=\"container\"></div>"
  []
  [:div#container}])
;; ou
(defn app
  "<div id=\"container\"></div>"
  []
  [:div {:id "container"}}])

```

**Main Function**
```clojure
;; ^:export -> Torna acessível a função 'main' para usá-la no idex.html.
(defn ^:export main
  []
  (r/render
    [app]
    (.getElementById js/document "app")))
```

## 03 State

`reagent.core/atom` - Muito parecido com um átomo padrão do clojure, porém, monitora todas as chamadas de *deref* em cima dele.

## 04 Creating Components

Os componentes não existem apenas para fins de visualização.
Eles também são responsáveis por lidar com interações do usuário, como cliques, digitação e outros eventos.

Dentro de cada componente, é comum definir listeners (event handlers), que ficam “ouvindo” essas interações e executam a lógica necessária quando elas ocorrem. Essa é uma prática amplamente adotada no desenvolvimento de interfaces modernas.

Em muitos frameworks tradicionais, existe uma *separação explícita* entre:
- **View** (camada de apresentação)
- **Controller** (camada de lógica e controle)
No *React* e, por consequência, no *Reagent*, essa separação não é feita da mesma forma.

No React/Reagent:
- A lógica da *view* e a lógica do *controle/interação* ficam juntas dentro do mesmo componente.
Essa abordagem traz algumas vantagens importantes:
- Facilita o desenvolvimento, pois o comportamento do componente fica concentrado em um único lugar.
- Torna os componentes mais *autossuficientes*.
Aumenta a *reutilização*, já que o componente carrega tanto sua apresentação quanto seu comportamento.

O estado final do componente "app" será:
```clojure
(defn app
  []
  [header]
  [gigs]
  [orders]
  [footer])
```

**TODO**
- [x] Criar o diretório dos componentes.
- [x] Criar o arquivo "header.cljs".
- [x] Definir a função "header".
- [x] Criar o arquivo "gigs.cljs".
- [x] Definir a função "gigs".
- [x] Criar o arquivo "orders.cljs".
- [x] Definir a função "orders".
- [x] Criar o arquivo "footer.cljs".
- [x] Definir a função "footer".
- [x] Importar as arquivos criados no "core.cljs".
- [x] Em "header.cljs" importar o logo.
- [x] Em "footer.cljs" importar o ícone.

## 05 Displaying Gigs

O componente gigs irá mostrar todos os itens para o usuário.

**TODO**
- [x] Alterar o hiccup do componente gigs para main.
- [x] Criar uma *:div* com a classe *gigs*.
- [x] Importar *giggin.state*.
- [x] Aplicar uma função *map* no nosso estado.
- [x] Montar o componente visual.
- [x] Popular os componentes com os valores do estado.
- [x] Adicionar uma chave para cada elemento do componente.

## 06 List Comprehension

Refatorando o componente *gigs* para melhorar legibilidade.

## 07 Add To Order

Quando clicar no botão `+`, precisamos adicionar os pedidos ao componente `orders`.

Precisamos criar um átomo do *reagent* para adicionar os pedidios nesse átomo.

No `:on-click` eu preciso retornar uma função pro *React* guardar e executar quando a ação acontecer.

## 08 For Over Orders

Listas as ordens dentro do componente.
Utilizar *aside* para definir um conteúdo tangencial ao conteúdo principal.

**TODO**
- [x] Trocar a *div* de orders por um *aside*.
- [x] Importar *state* para dentro do arquivo de *orders*.
- [x] Iterar sobre todas as ordens dentro de *state*.
- [x] Adicionar a *div* de imagem.
- [x] Adicionar a *div* do conteúdo de ordens.
- [x] Adicionar a *div* de *action*.

## 09 Remove From Order

Para remover os pedidos da lista de pedidos, é preciso adicionar *listeners*.
Atualizar o estado sempre que o usuário interagir com o botão.

- [x] Adicionar um botão a cada pedido.
- [x] Adicionar um *listener* ao botão.
- [x] Adicionar conteúdo ao botão (ícone).

## 10 Order Total

Exibir o total do preço dos pedidos realizados. Quando o usuário adicionar
os pedidos ao componente de pedidos, mostrar a soma total dos pedidos abaixo.

- [x] Adicionar mais uma *div* ao componente **orders**, com a classe *total*.
- [x] Adicionar um outro botão para remover todos os pedidos.
- [x] Adicionar um *listener* ao botão para remover os pedidos.
- [x] Definir a função que ira fazer a somatória dos pedidos.

## 11 Format Price

Alterar o formato em que o preço é exibido na seção de pedidos.

- [x] Verificar se existem pedidos feitos.
- [x] Alterar a exibição caso não tenha nenhum pedido.
- [x] Criar uma função para formatar o preço.

## 11 Refactoring Functions

