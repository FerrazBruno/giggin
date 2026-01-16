(ns giggin.components.gigs
  (:require
    [giggin.state :as state]))

(defn gigs
  []
  [:main
   [:div {:class "gigs"}
    (map
      (fn [gig]
        [:div {:class "gig"
               :key (:id gig)}
         [:img {:class "gig__artwork"
                :src (:img gig)
                :alt (:title gig)}]
         [:div {:class "gig__body"}
          [:div {:class "gig__title"}
           [:div {:class "btn btn--primary float--right tooltip"
                  :data-tooltip "Add to order"}
            [:i {:class "icon icon--plus"}
             "title"]]
           [:p {:class "gig__price"}
            (:price gig)]
           [:p {:class "gig_description"}
            (:desc gig)]]]])
      (vals @state/gigs))]])

