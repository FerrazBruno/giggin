(ns giggin.components.gigs
  (:require
    [giggin.state :as state]))

(defn gigs
  []
  [:main
   [:div.gigs
    (for [{:keys [id title desc img price]} (vals @state/gigs)]
      [:div.gig {:key id}
       [:img.gig__artwork {:src img :alt title}]
       [:div.gig__boddy
        [:div.gig__title
         [:div.btn.btn--primary.float--right.tooltip
          {:data-tooltip "Add to order"}}
          [:i.icon.icon--plus "title"]]
         [:p.gig__price
          price]
         [:p.gig_description
          desc]]]])]])

