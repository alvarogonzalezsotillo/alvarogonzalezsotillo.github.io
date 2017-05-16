(owp/add-project-config
 '("alvarogonzalezsotillo.github.io"
   :repository-directory "/home/alvaro/github/alvarogonzalezsotillo.github.io"
   :remote (git "https://github.com/alvarogonzalezsotillo/alvarogonzalezsotillo.github.io.git" "master")
   ;; you can use `rclone` with `:remote (rclone "remote-name" "/remote/path/location")` instead.
   :site-domain "https://alvarogonzalezsotillo.github.io/"
   :site-main-title "Álvaro González Sotillo"
   :site-sub-title ""
   :force-absolute-url nil
   :theme-root-directory "/home/alvaro/github/alvarogonzalezsotillo.github.io/themes"
   :theme (alvaro)
   :source-browse-url ("Github" "https://github.com/alvarogonzalezsotillo"
   ))
