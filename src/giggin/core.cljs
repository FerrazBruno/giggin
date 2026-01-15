(ns giggin.core
  (:require
    [giggin.components.footer :refer [footer]]
    [giggin.components.gigs   :refer [gigs]]
    [giggin.components.header :refer [header]]
    [giggin.components.orders :refer [orders]]
    [reagent.core :as r]))

(defn app
  []
  [:div {:class "container"}
   [header]
   [gigs]
   [orders]
   [footer]])

(defn ^:export main
  []
  (r/render
    [app]
    (.getElementById js/document "app")))

