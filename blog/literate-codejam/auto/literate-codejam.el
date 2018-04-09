(TeX-add-style-hook
 "literate-codejam"
 (lambda ()
   (TeX-add-to-alist 'LaTeX-provided-class-options
                     '(("article" "a4paper")))
   (TeX-add-to-alist 'LaTeX-provided-package-options
                     '(("inputenc" "utf8") ("fontenc" "T1") ("ulem" "normalem") ("geometry" "margin=2cm") ("babel" "spanish")))
   (add-to-list 'LaTeX-verbatim-environments-local "lstlisting")
   (add-to-list 'LaTeX-verbatim-macros-with-braces-local "lstinline")
   (add-to-list 'LaTeX-verbatim-macros-with-braces-local "hyperref")
   (add-to-list 'LaTeX-verbatim-macros-with-braces-local "hyperimage")
   (add-to-list 'LaTeX-verbatim-macros-with-braces-local "hyperbaseurl")
   (add-to-list 'LaTeX-verbatim-macros-with-braces-local "nolinkurl")
   (add-to-list 'LaTeX-verbatim-macros-with-braces-local "url")
   (add-to-list 'LaTeX-verbatim-macros-with-braces-local "path")
   (add-to-list 'LaTeX-verbatim-macros-with-delims-local "lstinline")
   (add-to-list 'LaTeX-verbatim-macros-with-delims-local "path")
   (TeX-run-style-hooks
    "latex2e"
    "article"
    "art10"
    "inputenc"
    "fontenc"
    "graphicx"
    "grffile"
    "longtable"
    "wrapfig"
    "rotating"
    "ulem"
    "amsmath"
    "textcomp"
    "amssymb"
    "capt-of"
    "hyperref"
    "geometry"
    "xcolor"
    "babel"
    "caption"
    "listings")
   (LaTeX-add-labels
    "sec:orgd79cd2f"
    "sec:orgf7a3128"
    "sec:orgdee83be"
    "sec:org033decc"
    "sec:org4463133"
    "sec:org167ad1a"
    "sec:orgb45dc8a"
    "sec:org4b38788"
    "sec:orgf7e077b"
    "sec:org8855ed0"
    "sec:org0d23658"
    "sec:org5a4fd4e"
    "sec:org985e9da"
    "sec:org038a9aa"
    "sec:orge4b543b"
    "sec:orgf50ad67"))
 :latex)

