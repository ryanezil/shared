# Testing CamelK

## Install CamelK operator

Configure Maven repositories when installing CamelK operator

```bash
kamel install \
  --maven-repository https://maven.repository.redhat.com/ga/ \
  --maven-repository https://jitpack.io@snapshots
```

## Run Demo

```bash
kamel run SampleInject.java
```

