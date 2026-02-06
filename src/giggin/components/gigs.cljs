(ns giggin.components.gigs
  (:require
    [giggin.helpers :as h]
    [giggin.state :as state]))

(defn gigs
  []
  (let [add-to-order #(swap! state/orders update % inc)]
    [:main
     [:div.gigs
      (for [{:keys [id title desc img price]} (vals @state/gigs)]
        [:div.gig {:key id}
         [:img.gig__artwork {:src img :alt title}]
         [:div.gig__body
          [:div.gig__title
           [:div.btn.btn--primary.float--right.tooltip
            {:data-tooltip "Add to order"
             :on-click #(add-to-order id)}
            [:i.icon.icon--plus]]
           title]
          [:p.gig__price (h/format-price price)]
          [:p.gig__desc desc]]])]]))

