# Requisitos de Hardware e Software

## Requisitos mínimos de hardware

| Memória | CPU                           | Armazenamento |
|--------|--------------------------------|---------------|
| 512 MB | 1 núcleo físico (1.0 GHz)      | 500 MB        |

### CPU
- 1 núcleo físico
- Arquitetura 64 bits (x86_64 ou ARM64)
- Frequência mínima: 1.0 GHz
- Cache: padrão da CPU (L1/L2), sem requisitos mínimos específicos

### Memória RAM
- 512 MB  
- Mínimo funcional para execução da JVM e aplicação simples em modo terminal

### Armazenamento
- 500 MB de espaço livre
- Inclui JDK/JRE, aplicação e arquivos temporários da JVM

---

## Requisitos recomendados de hardware

| Memória | CPU                            | Armazenamento |
|--------|---------------------------------|---------------|
| 2 GB   | 2 núcleos físicos (1.5 GHz)     | 2 GB          |

### CPU
- 2 núcleos físicos
- Arquitetura 64 bits
- Frequência recomendada: 1.5 GHz ou superior
- Cache: padrão da CPU (L1/L2), sem requisitos mínimos específicos

### Memória RAM
- 2 GB
- Garante execução confortável da JVM, evitando swap e lentidão

### Armazenamento
- 2 GB de espaço livre
- Permite atualizações do Java, logs e expansão futura sem impacto

---

## Sistema Operacional
- Windows 10 ou superior (64 bits)
- Linux 64 bits
- macOS 64 bits (Intel ou Apple Silicon)

> Sistemas 32 bits não são suportados pelo Java 21.

---

## Software obrigatório
- OpenJDK 21 (64 bits)

Exemplo de distribuição oficial:
- JDK 21.0.8 (Windows x64) — 164.42 MB  
  https://download.oracle.com/java/21/archive/jdk-21.0.8_windows-x64_bin.exe

---

## Ambiente de validação (usado para o desenvolvimento)

**Lenovo Ideapad S145**
- CPU: Intel i3-8130U (2C/4T, até 3.4 GHz Turbo Boost)
- RAM: 12 GB DDR4 (2600 MHz)
- Armazenamento: SSD NVMe 256 GB
- SO: Debian GNU/Linux 13 (Trixie, 64 bits)
- JVM: OpenJDK 21

---

## Máquina Recomendada

| Componente    | Descrição                                                          | Valor (R$) | Link |
|---------------|--------------------------------------------------------------------|------------|------|
| Processador   | Intel Core i3 3240 – 3ª Geração, LGA 1155, 3.4GHz, 2 núcleos        | 54,90      | [Mercado Livre](https://www.mercadolivre.com.br/processador-intel-core-i3-3240-3-geraco-lga-1155-34ghz-2-nucleos/p/MLB22942533) |
| Placa-mãe     | TGT H61-T, DDR3, LGA 1155, mATX, Chipset Intel H61                 | 129,90     | [Pichau](https://www.pichau.com.br/placa-mae-tgt-h61-t-ddr3-lga-1155-m-atx-chipset-intel-h61-tgt-h61-t) |
| Memória RAM   | 4GB DDR3 1600MHz (1×4GB)                                           | 79,99      | [Pichau](https://www.pichau.com.br/memoria-tgt-galadius-300-4gb-1x4gb-ddr3-1600mhz-c11-tgt-gld300-4gb) |
| Armazenamento | SSD 120GB SATA III                                                 | 139,90     | [Pichau](https://www.pichau.com.br/ssd-tgt-egon-s10-120gb-sata-iii-6gb-s-leitura-450mb-s-gravacao-350mb-s-tgt-egs10-120) |
| Fonte         | TGT Enfield 500W, ATX, Bivolt                                      | 99,99      | [Pichau](https://www.pichau.com.br/fonte-tgt-enfield-500w-atx-bivolt-preto-tgt-efd-bk01) |
| Gabinete      | Aigo Q2522 Mini-Tower                                              | 59,99      | [Pichau](https://www.pichau.com.br/gabinete-office-aigo-q2522-mini-tower-preto-ac-q2522-b-hq1) |
| Placa Gráfica | Intel® HD Graphics 2500 (integrada ao processador)                 | 0,00       | — |

> Observação: a máquina recomendada excede significativamente os requisitos mínimos,
> garantindo ampla margem de desempenho, estabilidade da JVM e longevidade do ambiente.
