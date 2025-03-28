# SYSTEM DESIGN PREPARATION
* How to prepare for and answer system design questions

## Objective
*Learning about and implementing large-scale distributed system is not easy. I do not want to give the impression that it's something that can be learnt in a month.* 
What this repository aims to achieve, is for software engineers and students to get a rough idea of how the thought process of designing a large scale works and how big companies have managed to solve really hard problems. Along with that, there is a recent trend for companies to have an open-ended interview with system design questions, which is at times hard for engineers of all levels if they haven't gotten the opportunity to work on such systems themselves. 

This is a collection of links/documents for the following use cases:
a) Prepare for a system design or open-ended rounds.
b) Learn more about how large-scale systems work and thought process of designing a new system.

## Index
- [ ] [Starting point](#start)
- [ ] [basics](#basics)
- [ ] [How to answer in interviews](#howtoans)
- [ ] [Steps how I approach the system design questions in interviews](#myapproach)
- [ ] [Common Design questions](#designques)
- [ ] [Low Level Design - Question](#lldquestions)
- [ ] [architecture](#architecture)
- [ ] [company engineering blog links](#blog)
- [ ] [Low on time ?](#tldr)

## <a name='start'> Starting point </a>

For a very broad overview please go through these lectures, really useful:
* [Gaurav Sen's system design series](https://www.youtube.com/playlist?list=PLMCXHnjXnTnvo6alSjVkgxV-VH6EPyvoX)
Starts from simple stuff like load balancing and message queues, then moves to building full systems like Whatsapp and Tinder.

* [david malans cs75 scalability talk](https://www.youtube.com/watch?v=-W9F__D3oY4&list=PLmhRNZyYVpDmLpaVQm3mK5PY5KB_4hLjE&index=10)
Feel free to go through other lectures if needed. 

* [david huffman's talk , scaling up talk](https://www.udacity.com/course/web-development--cs253) ([Youtube link](https://www.youtube.com/watch?v=pjNTgULVVf4&list=PLVi1LmRuKQ0NINQfjKLVen7J2lZFL35wP&index=1))

* [scalability for dummies](http://www.lecloud.net/tagged/scalability)

* [Designing data intensive appliations](https://dataintensive.net/) This is by far one of the best books about large-scale systems and the practical challenges encountered during building them. It's focussed more on data-oriented applications though.

* [System Design Interview Preperation Series by CodeKarle](https://www.youtube.com/watch?v=3loACSxowRU&list=PLhgw50vUymycJPN6ZbGTpVKAJ0cL4OEH3) This is a collection of some of the most commonly asked system design interview question explain in a very detailed and straight forward manner.


These talks should give you a starting point on how to think about such problems.

## <a name='basics'> Basics </a>

But before you begin, here are some topics(in no particular order) which in my opinion you should have a decent idea of before proceeding.

1. Operating system basics: how a file system, virtual memory, paging, instruction execution cycle etc work
(For starters silbershatz should be enough. If you already have decent knowledge try stallings book on OS)
2. Networking basics: 
Should know the TCP/IP stack, basics of how Internet, HTTP, TCP/IP work at the minimum. cs75 on youtube (1st lecture) should give a broad overview. I personally love [networking-a top down approach](http://www.amazon.com/Computer-Networking-Top-Down-Approach-Edition/dp/0132856204).
3. Concurrency basics: threads, processes, threading in the language you know. Locks , mutex etc. 
4. DB basics: types of DB's (SQL vs noSQL etc ), hashing and indexing, EAV based databases, Sharding, caching for databases, master-slave etc
5. A basic idea of how a basic web architecture is: say load balancers, proxy, servers, Database servers, caching servers, precompute, logging big data etc. Just know broadly what is each layer for.  
6. very basic summary of what the [CAP theorem](http://robertgreiner.com/2014/08/cap-theorem-revisited/) is (Have never been asked about the theorem itself, but knowing it will help you in designing large-scale systems. 

## <a name='howtoans'> How to answer in interviews </a>

* I found [hiredintech](http://www.hiredintech.com/system-design) videos an excellent place to start with. The way how to approach a design question as given in the link is really useful. It goes into how we start with clearing the use-cases of the system, then thinking in the abstract manner of the various component and the interactions. Think about the bottlenecks of the system and what is more critical for your system (eg latency vs reliability vs uptime etc) Address those giving the tradeoff of your approach. 

* [system design in crack the coding interview](http://www.flipkart.com/cracking-coding-interview-150-programming-questions-solutions-english-5th/p/itmdz4pvzbhcv6uv): good approach on how to begin attacking a problem by first solving for a small usecase then expanding the system.

* The best way to prepare for such questions is do mock interviews, pick any topic (given below) try to come up with a design and then go and see how and why it is designed in that manner. There is absolutely no alternative to practice!! Whiteboarding a system design question is similar to actually writing code and testing it! Just reading will only take you so far.

## <a name='myapproach'>Steps how I approach the system design questions in interviews</a>

These are the steps I go through mentally in the interviews, followed by actual interview experiences:

* a) **Be absolutely sure you understand the problem being asked**, clarify on the onset rather than assuming anything 
* b) **Use-cases**. This is critical, you MUST know what is the system going to be used for, what is the scale it is going to be used for. Also, constraints like requests per second, requests types, data written per second, data read per second.
* c) Solve the problem for a **very small set**, say, 100 users. This will broadly help you figure out the data structures, components, abstract design of the overall model.
* d) Write down the various components figured out so far and how will they interact with each other.
* e)  As a rule of thumb remember at least these :
 * 1. processing and servers
 * 2. storage 
 * 3. caching 
 * 4. concurrency and communication
 * 5. security 
 * 6. load balancing and proxy 
 * 7. CDN 
 * 8.  Monetization: if relevant, how will you monetize?
 eg. What kind of DB (Is Postgres enough, if not why?), do you need caching and how much, is security a prime concern? 
* f) **Special cases** for the question asked. Say designing a system for storing thumbnails, will a file system be enough? What if you have to scale for facebook or google? Will a nosql based database work?
* g) After I have my components in place, what I generally try to do is look for minor optimization in various places according to the use-cases, various tradeoffs that will help in better scaling in 99% cases.
* h) [Scaling out or up]  (http://highscalability.com/blog/2014/5/12/4-architecture-issues-when-scaling-web-applications-bottlene.html)
* i) Check with the interviewer is there any other special case he is looking to solve? Also, it really helps if you know about the company you are interviewing with, what its architecture is, what will the interviewer have more interest in based on the company and what he works on? 

## <a name='designques'> Common Design questions </a>
It generally depends what you are and you will be working on. Also what your level is but these are some of the more frequent interview questions.

* Design amazon's frequently viewed product page (eg. which shows the last 5 items you saw)
* Design an online poker game for multiplayer. Solve for persistence, concurrency, scale. Draw the ER diagram for this 
* Design a [url compression system] (http://www.hiredintech.com/system-design/the-system-design-process/)
* [Search engine](http://infolab.stanford.edu/~backrub/google.html) (generally asked with people who have some domain knowledge): basic crawling, collection, hashing etc. Depends on your expertise on this topic
* Design dropbox's architecture. [good talk on this](https://www.youtube.com/watch?v=PE4gwstWhmc)
* Design a [picture sharing website](http://highscalability.com/blog/2011/12/6/instagram-architecture-14-million-users-terabytes-of-photos.html). How will you store thumbnails, photos? Usage of CDNS? caching at various layers etc.
* * Design a news feed (eg. Facebook , Twitter): [news feed](http://www.quora.com/Software-Engineering-Best-Practices/What-are-best-practices-for-building-something-like-a-News-Feed)
* Design a product based on maps, eg hotel / ATM finder given a location. 
* Design malloc, free and [garbage collection system](http://courses.cs.washington.edu/courses/csep521/07wi/prj/rick.pdf). What data structures to use? decorator pattern over malloc etc.
* Design a site like [junglee.com](http://www.junglee.com/) i.e price comparision, availability on e-commerce websites. When and will you cache, how much to query, how to crawl efficiently over e-commerce sites, sharding of databases, basic database design
* A web application for instant messaging, eg [whatsapp](http://highscalability.com/blog/2014/2/26/the-whatsapp-architecture-facebook-bought-for-19-billion.html), facebook chat. Issues of each, scaling problems, status and availability notification etc.
* Design a system for collaborating over a document simultaneously (eg [google docs](https://neil.fraser.name/writing/sync/))
* (very common:) top 'n' or most frequent items of a running stream of data
* Design election commission architecture :
 Let's say we work with the Election Commission. On Counting day, we want to collate the votes received at the lakhs of voting booths all over the country. Each booth has a voting machine, which, when connected to the network, returns an array of the form {[party_id, num_votes],[party_id_2, num_votes_2],...}. We want to collect these and get the current scores in real time. The report we need continuously is how many seats is each party leading in. Please design a system for this.
* Design a logging system
 (For web applications, it is common to have a large number of servers running the same application, with a load balancer in front to distribute the incoming requests. In this scenario, we want to check and alarm in case an exception is thrown in any of the servers. We want a system that checks for the appearance of specific words, "Exception", "Disk Full" etc. in the logs of any of the servers. How would you design this system?)
 * [Design Google Maps].(https://www.codekarle.com/system-design/Google_Maps-system-design.html)
 * [Design a Video Conferencing System like Zoom/WebEx].(https://www.codekarle.com/system-design/Zoom-system-design.html)

## <a name='lldquestions'> Low Level Design Questions </a>
* [Cab/Taxi Booking like Uber, Ola](https://www.youtube.com/watch?v=Yn7C0x5ozx4&t=967s)
* [Cache](https://www.youtube.com/watch?v=B7iCXl_KSoM)
* [Parking Lot](https://www.youtube.com/watch?v=7IX84K9g23U&t=1s)
* [Movie Ticket Booking](https://www.youtube.com/watch?v=Xny0IdvJ-1M&list=PL564gOx0bCLpAL7yMJqOuK3_hBuLkyRhn)
* [Chess Game](https://www.youtube.com/watch?v=RVHNcng0oF0&list=PL564gOx0bCLqTolRIHIsR2JPv11w8LESW&index=4)
* [Airline reservations system](https://www.youtube.com/watch?v=54cXxQyeCMQ)

## <a name='lldquestions'> Design Patterns </a>
* [The Catalog of Design Patterns](https://refactoring.guru/design-patterns/catalog)

## <a name='architecture'>Architectures :</a>

Personally I looked into the following architectures:

* [Basics of google search](http://infolab.stanford.edu/~backrub/google.html)
* Basics of messaging frameworks like Kafka , queuing architectures like rabbitmq.
* Broad overview and advantages of Redis , mongodb , cassandra. 
* [Google file system](http://static.googleusercontent.com/media/research.google.com/en//archive/gfs-sosp2003.pdf)
* [Google architecture] (http://highscalability.com/google-architecture)
* [Instagram](http://instagram-engineering.tumblr.com/post/13649370142/what-powers-instagram-hundreds-of-instances) and other image based social networks
* [Memcache scaling by facebook](https://cs.uwaterloo.ca/~brecht/courses/854-Emerging-2014/readings/key-value/fb-memcached-nsdi-2013.pdf)
* [Twitter scaling](https://www.youtube.com/watch?v=z8LU0Cj6BOU) and facebook feeds
* [facebook graph api](https://cs.uwaterloo.ca/~brecht/courses/854-Emerging-2014/readings/data-store/tao-facebook-distributed-datastore-atc-2013.pdf)
* [facebook haystack needle architecture](https://www.usenix.org/legacy/event/osdi10/tech/full_papers/Beaver.pdf)
* [youtube architecture and optimizations for video](https://www.youtube.com/watch?v=ZW5_eEKEC28)

## <a name='blog'>Company engineering blog links </a>

courtesy [checkcheckzz](https://github.com/checkcheckzz/system-design-interview#toc)

Depending on where you are interviewing, go through the company blog. VERY USEFUL IN INTERVIEWS! It really helps if you have an idea of the architecture, as the questions asked will generally be of that domain and your prior knowledge will help out here.

* [Airbnb Engineering](http://nerds.airbnb.com/)
* [Amazon](https://developer.amazon.com/blogs)
* [Amazon AWS](https://aws.amazon.com/blogs/)
* [Bandcamp Tech](http://bandcamptech.wordpress.com/)
* [BankSimple Simple Blog](https://www.simple.com/engineering/)
* [Bitly Engineering Blog](http://word.bitly.com/)
* [Cloudera Developer Blog](http://blog.cloudera.com/blog/)
* [Dropbox Tech Blog](https://tech.dropbox.com/)
* [Engineering at Quora](http://engineering.quora.com/)
* [Etsy Code as Craft](http://codeascraft.com/)
* [Facebook Engineering](https://www.facebook.com/Engineering)
* [Flickr Code](http://code.flickr.net/)
* [Foursquare Engineering Blog](http://engineering.foursquare.com/)
* [Google Research Blog](http://googleresearch.blogspot.com/)
* [Groupn Engineering Blog](https://engineering.groupon.com/)
* [High Scalability](http://highscalability.com/)
* [Instagram Engineering](http://instagram-engineering.tumblr.com/)
* [LinkedIn Engineering](http://engineering.linkedin.com/blog)
* [Oyster Tech Blog](http://tech.oyster.com/)
* [Pinterest Engineering Blog](http://engineering.pinterest.com/)
* [Songkick Technology Blog](http://devblog.songkick.com/)
* [SoundCloud Backstage Blog](https://developers.soundcloud.com/blog/)
* [Square The Corner](http://corner.squareup.com/)
* [THE REDDIT BLOG](http://www.redditblog.com/)
* [The GitHub Blog](https://github.com/blog/category/engineering)
* [The Netflix Tech Blog](http://techblog.netflix.com/)
* [Twilio Engineering Blog](http://www.twilio.com/engineering)
* [Twitter Engineering](https://engineering.twitter.com/)
* [Uber Engineering](https://eng.uber.com/)
* [Walmart Labs Tech Blog](https://medium.com/walmartlabs)
* [WebEngage Engineering Blog](http://engineering.webengage.com/)
* [Yammer Engineering](http://eng.yammer.com/blog/)
* [Yelp Engineering Blog](http://engineeringblog.yelp.com/)
* [Smarkets Blog](https://smarketshq.com/)

## <a name='tldr'>Low on time ?</a>

**I would HIGHLY recommend you do not take a shortcut unless you have a week or so for an interview. System design is best learnt by practising, shortcuts might help you in the short term, but would recommend coming back to this link for an in-depth understanding after the interview**

* a) Go through cs76 and Udacity's links given above for scaling systems. 
* b) Go through the engineering blog of the company you are interviewing in (or if its a startup go through the link of the company closest to yours)
* c) See this talk: http://www.hiredintech.com/system-design/the-system-design-process/ and develop a process for how to answer such questions.
* d) Remember these terms, just roll over them in your interview in your mind, and if relevant mention it in the interview 
 1. processing and servers
 2. storage 
 3. caching 
 4. concurrency and communication
 5. security 
 6. load balancing and proxy 
 7. CDN 
 8. Monetization

Best of luck :+1:, feel free to send pull requests to add more content to this git!


# Plaform Engineering Roadmap

An opinionated roadmap to become a Platform Engineer.

The roadmap is inspired by [Teivah's SRE roadmap](https://github.com/teivah/sre-roadmap), but my idea is a bit different.
In time, I want to create something similar to [roadmap.sh](https://roadmap.sh/) but for Platform Engineers.

![A picture from mbianchidev's Platform's Engineering Inferno talk from DevOps Days Amsterdam](platform-engineering-inferno.jpg)

This picture is from my DevOpsDay Amsterdam 2024 talk - Platform Engineering's Inferno - you can find a video [here](https://www.youtube.com/watch?v=dWn48x4v34Q).

I want this roadmap to be useful to the largest amount of people and if you want to help you are very welcome. Any contribution matters, may that be an input, a feedback or a PR.

_Note: This repo also contains a [Platform Engineering Manifesto](platform-engineering-manifesto.md) which is playfully inspired by the Agile Manifesto._

## Individual 

### YAML

* YAML (not even kidding you have to learn YAML. It's everywhere and it is the first thing to learn)

### Programming

* Programming languages (Python, Golang, Typescript) - _you don't necessarily need to be a master at these but it helps a ton_
* Version control (Git)
* SDKs

### Linux

* Bash scripting
* Navigating the filesystem
* Understand and manipulate both RAM and disk
* Understand and manipulate processes
* Understand cgroups and resource utilization
* Security (SELinux)
* Package management
  * rip
  * yum
  * dnf

### Network

* Protocols
  * TCP/IP vs UDP
  * HTTP (http1 vs http2)
  * TLS/SSL
  * HTTPS
  * DNS
  * SSH
* Navigate and troubleshoot network 
 * DNS
 * DHCP
 * Firewall (Iptables)
* ISO-OSI model
* Network topologies
* Discoverability
* Load Balacing
* Proxy and reverse-proxy

### Distributed systems and datastores

* _Queues_
  * Kafka
  * RabbitMQ
  * SQS
  * ActiveMQ
  * Event Log vs. Message Queue
  * _Load balancer_
    * Load distribution concepts
    * Layer 4 vs. layer 7 load balancer
* _APIs_
    * Stateful vs. stateless
    * REST
    * Microservices: pros and cons
    * GraphQL
    * gRPC
* Caching and key-value stores
  * etcd
  * Valkey / Redis
  * Memcached
  * In-memory databases
* CDN (Content Delivery Network)
  * Cloudflare
  * Akamai
  * Fastly
* _Databases_
  * _Types of databases_
    * NoSQL vs. Relational databases
      * MongoDB
    * Relational vs. Document-based
    * Column-oriented databases (OLAP)
      * ClickHouse
    * Graph databases
    * Vector databases
    * Objects-based storage
  * ACID principles
  * CAP Theorem
  * Indexing
  * Transaction
  * Storage

### DevOps

* _DevOps Concepts_
  * Culture over tools
  * Feedback loops
  * Effective communication
  * Continuous improvement
  * Toolchain
  * Pipelines
  * Automated testing
  * Everything as -Ops (NetOps, DBOps, DocOps...)
* _Cloud_
  * SaaS
  * PaaS
  * IaaS
  * Serverless
    * Knative
    * Vendor-specific services to deploy serverless apps
* Environments
  * Purpose of environments
  * Isolation
  * Multitenancy vs single tenancy
* CI/CD
  * Vendor-specific services offering CI/CD capabilities
  * SOPS
    * Cloud Specific tools
    * Hashicorp Vault
  * GitOps
    * ArgoCD
    * FluxCD
    * Temporal.io
* IaC (Infrastructure as Code)
  * Configuration management
    * Ansible
    * Puppet
    * Chef
  * Provisioning and management
   * Open-Tofu
   * Terraform
   * Pulumi
   * CloudFormation (AWS proprietary)
   * Bicep (Azure proprietary)
* Cloud Providers
  * AWS
  * GCP
  * Azure
* Version Control Products
  * GitHub
  * GitLab
  * Bitbucket

### Rollout
 
* _Concepts_ 
  * Bake time
  * Feature flag
  * Feature freeze
  * Rollout supervision
* _Rollout types_
  * Blue green rollout
  * Canary rollout
  * Progressive rollout
  * Shadow rollout

### Observability
 
* _Concepts_
  * Difference between telemetry, monitoring and observability
  * Trace vs. metric vs. log
  * APM (Application Performance Monitoring)
  * Percentiles
* _Alerting_
  * ChatOps
  * Slow vs. fast burn alert
* _Log Management_
  * Levels
  * Rotation
  * Aggregation
  * Retention
* _Tools_
  * Prometheus
  * Grafana
  * OpenTelemetry
  * Datadog
  * New Relic
  * Jaeger
  * Sumo Logic
  * Fluentd
  * OpsGenie
  * PagerDuty

### Security

* Encryption
  * Algorithms
  * Certificates
  * TLS
  * PKI
  * Signatures
* Authentication
* Authorization
* IAM (Identity Access Management)
  * OPA (Open Policy Agent)
* DevSecOps
  * SAST
  * DAST
* Container scanning
* Threat detection
* CNAPP (Cloud Native Application Protection Platform)
* CDR

### Site Reliability

* _Concepts_
  * Hard vs. soft dependencies in a system
  * _Scalability_
    * Concepts
* _Requests_
  * Rate limiting
  * Throughput
* _Practices_
  * Chaos engineering 

### Cloud Native

* Containers
  * Docker
  * Tags
  * OCI (Open Container Initiative)
  * Container registry
* Container runtime
  * Containerd
  * CRI-O (Container Runtime Interface - Orchestrator)
* Container orchestration
* Kubernetes
  * Nodes
  * Control plane
  * etcd
  * kubectl
  * Namespaces
  * Pods
  * Scheduler
  * Health checks
  * Liveness probes vs readiness probes
  * Replica sets
  * Deployments
  * Services
  * Ingress
  * ConfigMaps
  * Helm vs Kustomize
  * Secrets
  * DaemonSets
  * Init containers & sidecar pattern
  * eBPF and Kernel-level software
  * StatefulSets
  * Storage classes
  * Persistent volumes and claims
  * CSI (Container Storage Interface)
  * CNI (Container Network Interface)
    * Cilium
  * ClusterIP vs. NodePort vs. LoadBalancer
  * Service Meshes
    * Linkerd
    * Istio
  * Network policies
  * Service accounts
  * RBAC (Role-based access control)
  * Jobs & CronJobs
  * HPA (Horizontal Pod Autoscaler)
  * VPA (Vertical Pod Autoscaler)
  * Cluster Autoscaler
  * Node scaling
    * Karpenter
  * Pod Disruption Budgets
  * Resource quotas
  * Limit ranges
  * Taints and tolerations
  * Node affinity
  * Pod affinity vs pod anti-affinity
  * Pod security policies
  * Admission controllers
  * Operators
  * CRDs (Custom Resource Definitions)
* CNCF Landscape

### Platform Engineering

* _Concepts_
  * Internal Development Platform
  * Platform Capability
  * Platform Catalog
  * Golden Paths
  * Self-service Platforms
  * Platform as a Product
  * DevEx (Developer Experience or UX for developers)
  * PMF (Platform Market Fit)
  * Platform ROI (Return On Investment)
* Internal Developer Platforms
  * Backstage _the OSS version is a builder of IDPs, not a complete IDP per se_
  * Mia Platform
  * Humanitec
  * Port
  * Portainer
  * Upbound
  * Northflank
  * Qovery

### Soft skills

* Being a nice person to work with (no, really it's important)
* _Communication_
  * Written
  * Oral
  * Presentation skills
* Collaboration
* Problem solving
* Curiosity
* Navigating ambiguity
* Blameless retrospectives

## Company

For a company to be successful in the long run, it needs to have a strong engineering culture. This is a list of things that can help to build such a culture.

### Coming soon
