#lang racket

(define deep-reverse (lambda (a) (
                            cond
                              [(null? a) a]
                              [(list? (car a)) (append (deep-reverse (cdr a)) (list (deep-reverse (car a))))]
                              [(null? (rest a)) a]
                              [(append (deep-reverse (cdr a)) (list (car a)))]
                              )
                 )
  )

(deep-reverse '(1 2 (3 4 (5 6))))