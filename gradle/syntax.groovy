// ======================
// Groovy Closures
// http://groovy-lang.org/closures.html
// ======================

// defining a closure
{ [closureParameters -> ] statements }

// A closure is an instance of `groovy.lang.Closure`
def listener = { e -> println 'Clicked on $e.source' }
assert listener instanceof Closure

// Implicit parameter
// when a closure does not explicitly define a parameter list (using ->),
// a closure always defines an implicit parameter, named `it`:
def greeting = { "Hello, $it!" }
// same as:
def greeting = { it -> "Hello, $it!" }
assert greeting('Patrick') == 'Hello, Patrick!'

// ======================
// https://docs.gradle.org/3.3/userguide/writing_build_scripts.html#groovy-dsl-basics
// Groovy Basics
// ======================
// Groovy automatically converts a property reference into a call to the appropriate getter or setter method.

// using a getter method
println project.buildDir
println getProject().getBuildDir()
// using a setter method
project.buildDir = 'target'
getProject().setBuildDir('target')

// closure delegate
repositories {
    println "in a closure"
}
repositories() { println "in a closure" }
repositories({ println "in a closure" })

// Colletions
def map = [name: 'Gromit', likes: 'cheese', id: 1234]
def emptyMap = [:]

def list = [5, 6, 7, 8]
def emptyList = []

// ======================
// Groovy Collections
// ======================
moduleProjects = subprojects.findAll {
	!it.name.equals('spring-build-src') && !it.name.equals('spring-framework-bom')
}
