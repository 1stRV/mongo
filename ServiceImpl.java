    @Override
    public void createCisPalletBoxBlockPack() {
        List<CisPallet> cisPallets = new ArrayList<>();
        List<CisBox> cisBoxes = new ArrayList<>();
        List<CisBlock> cisBlocks = new ArrayList<>();
        List<CisPack> cisPacks = new ArrayList<>();
        for (int f = 0; f < 100; f++) {
            for (int i = 0; i < 38; i++) {
                String randomCisPalletId = RandomStringUtils.randomAlphanumeric(32);
                String randomCisPalletStatus = RandomStringUtils.randomAlphanumeric(32);
                String randomCisPalletSapHeaderId = RandomStringUtils.randomAlphanumeric(32);
                String randomCisPalletSapDetailId = RandomStringUtils.randomAlphanumeric(32);
                CisPallet cisPallet = new CisPallet(randomCisPalletId, EnumPackageType.PALLET, randomCisPalletStatus, randomCisPalletSapHeaderId, randomCisPalletSapDetailId);
                cisPallets.add(cisPallet);

                for (int j = 0; j < 25; j++) {
                    String randomCisBoxStatus = RandomStringUtils.randomAlphanumeric(29);
                    String randomCisBoxSapHeaderId = RandomStringUtils.randomAlphanumeric(29);
                    String randomCisBoxSapDetailId = RandomStringUtils.randomAlphanumeric(29);
                    String randomCisBoxId = RandomStringUtils.randomAlphanumeric(29);
                    CisBox cisBox = CisBox.builder().cisId(randomCisBoxId).packageType(EnumPackageType.BOX).status(randomCisBoxStatus).sapHeaderId(randomCisBoxSapHeaderId).sapDetailId(randomCisBoxSapDetailId).parentCisPallet(cisPallet).build();
                    cisBoxes.add(cisBox);

                    for (int k = 0; k < 50; k++) {
                        String randomCisBlockId = RandomStringUtils.randomAlphanumeric(31);
                        String randomCisBlockStatus = RandomStringUtils.randomAlphanumeric(31);
                        String randomCisBlockSapHeaderId = RandomStringUtils.randomAlphanumeric(31);
                        String randomCisBlockSapDetailId = RandomStringUtils.randomAlphanumeric(31);
                        CisBlock cisBlock = CisBlock.builder().cisId(randomCisBlockId).packageType(EnumPackageType.BLOCK).status(randomCisBlockStatus).sapHeaderId(randomCisBlockSapHeaderId).sapDetailId(randomCisBlockSapDetailId).parentCisBox(cisBox).build();
                        cisBlocks.add(cisBlock);

                        for (int l = 0; l < 10; l++) {
                            String randomCisPackStatus = RandomStringUtils.randomAlphanumeric(50);
                            String randomCisPackSapHeaderId = RandomStringUtils.randomAlphanumeric(50);
                            String randomCisPackSapDetailId = RandomStringUtils.randomAlphanumeric(50);
                            String randomCisPackId = RandomStringUtils.randomAlphanumeric(50);
                            CisPack cisPack = CisPack.builder().cisId(randomCisPackId).packageType(EnumPackageType.PACK).status(randomCisPackStatus).sapHeaderId(randomCisPackSapHeaderId).sapDetailId(randomCisPackSapDetailId).parentCisBlock(cisBlock).build();
                            cisPacks.add(cisPack);
                        }
                    }
                }
            }
        }
        cisBoxRepository.insert(cisBoxes);
        cisBlockRepository.insert(cisBlocks);
        cisPackRepository.insert(cisPacks);
        cisPalletRepository.insert(cisPallets);
    }
}