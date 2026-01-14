# Giggin

## 01 Dev Setup
** ClojureScript **
`Reagent` - Interface entre o ClojureScript e o React.
`shadow-cljs` - Compila CLSJ, integra npm/node_modules e gerencia builds.
`Node.js` - ambiente de execução JS (runtime).

** CLJS -> shadow-cljs (node) -> JS -> Browser **

## 02 App Setup
[Código inicial do projeto](https://github.com/jacekschae/learn-reagent-course-files)
`giggin` - Projeto
`increments` - Soluções

Clonar o projeto:
`
git clone https://github.com/jacekschae/learn-reagent-course-files.git
`

Dentro do diretório 'giggin', baixar as dependências do ecossistema npm:
`
npm install
`

Baixar todas as dependências do ecossistema do Clojure/Script:
`
npx shadow-cljs watch app
`

** Diretórios: **
`node_modules` - Diretório onde o Node.js instala as dependências JavaScript listadas no 'packge.jsoni'.
`public` - Contém todos os arquivos estáticos que o browser pode acessar diretamente.
`src` - Contém todo o código fonte a ser compilado pelo shadow-cljs.

** Arquivos: **
`index.html` - Será o primeiro arquivo à ser lido pelo servidor.
`shadow-cljs.edn` - Dependências ClojureScript.
`package.json` - Dependências JavaScript. (ecossistema npm)
`package-lock.json` - Mantém 'congeladas' exatamente quais versões de todas as dependências JS que foram instaladas.

** Hiccup Syntax **
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

** Main Function **
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

